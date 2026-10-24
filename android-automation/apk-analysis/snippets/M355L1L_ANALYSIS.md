# m355L1l 资源提取方法初步分析

- 日期：2026-10-24
- 分支：`feature/auto-training-plugin`
- 输入源码：`snippets/I1Iii_m355L1l.java.txt`
- 源码文件 SHA：`ecdcadd0c1f9de781cef5472372d4c15ddcdf431`
- 方法位置：源码第 2978–3020 行

## 已确认的行为

方法签名：

```java
public static boolean m355L1l(String str, String str2, String str3, String str4)
```

控制流要点：

1. `new lL(str)`：以第一个参数构造 `lL` 对象；从后续用法看，它提供条目枚举和条目输入流。当前仅凭本方法尚不能确定其底层容器格式，但行为类似归档读取器。
2. `new File(str3)` 并调用 `mkdirs()`：第三个参数是输出根目录。
3. 遍历 `lLVar.I1I()` 返回的条目。
4. 仅处理条目名满足 `name.startsWith(str2)` 且非空的条目。因此第二个参数是条目名前缀过滤条件，不是简单的文件扩展名过滤。
5. 当条目是目录时创建目录；否则通过 `lLVar.m2873IL(entry)` 取得输入流，再将内容写入输出文件。
6. 输出路径规则：若第四个参数为空，目标为 `new File(outputRoot, entryName)`；若第四个参数非空，目标为 `new File(outputRoot, str4)`。所以第四个参数非空时，匹配到的多个文件可能写向同一目标文件名；是否实际这样调用，需要查看调用者。
7. 目标文件会被设置为可执行。
8. 成功处理至少一个匹配条目时返回 `true`；没有匹配条目时返回 `false`。捕获 `IOException` 时打印异常并返回 `false`。

## 对当前 OCR/字典研究的意义

- 这是一个按归档内路径前缀筛选并导出条目的通用提取方法。
- 它本身没有针对 `smn*Dict`、OCR、模板或按钮坐标的专用逻辑。
- 它可能用于从某个归档中导出资源，但必须解出调用者传入的四个参数，才能确定实际输入归档、条目前缀和输出目录。
- APK 根目录中未发现名字含 `smn` 或 `dict` 的 ZIP 条目，并不能排除字典存在于另一个被打包的归档、运行时生成文件或外部资源中。

## 下一步

1. 检查调用者 `Engine.extractApkAssets(String, String)`，完整解码传入的归档路径、条目前缀、输出目录和可选重命名参数。
2. 检查 `lL` 类构造函数、`I1I()`、`m2873IL(...)` 与 `ILil()`，确认容器格式、条目名称规范以及资源流释放方式。
3. 定位 `m340L1l()` 的实现，确认归档源路径。
4. 只有找到真实调用参数后，再针对具体归档条目列目录；不要继续把 `smn*Dict.txt` 当作已确认存在于 APK 根 ZIP 的文件。

## 证据边界

以上结论仅来自该方法在 JADX 中呈现的 Java 反编译代码。尚未证明实际调用使用哪个归档、是否包含字典、或字典记录的编码/匹配规则。

## 2026-10-24 补充：调用入口已核实

新增核对文件：[`com.main.engine/Engine.java`](https://github.com/wosafety0/UmaAI-Research/blob/feature/auto-training-plugin/android-automation/apk-analysis/snippets/com.main.engine/Engine.java)，当前 blob SHA：`51b29629709708c12a4e1aa319a2873fd782443e`。

已直接核对反编译源码：

- `Engine.extractApkAssets(String str, String str2)` 将参数交给 `lIlii.m355L1l(lIlii.m340lIII(), decodedPrefix + str, str2, str)`。
- 因而第 1 个参数来自 `lIlii.m340lIII()`；第 2 个参数是某个被混淆字符串解码后的前缀再拼接调用参数 `str`；第 3 个参数直接来自调用参数 `str2`；第 4 个参数直接来自调用参数 `str`。
- 该包装方法在 Engine 的分发逻辑中由 `i2 == 42` 分支调用。成功/失败结果会被转换成单字符状态字符串。
- 当前仓库的 `snippets/com.main.engine/` 目录中已包含 Engine.java，但仓库 snippets 目录中尚未找到 `lIlii` 类或 `IL1Iii` 字符串解码类源码；GitHub 代码搜索也没有返回这两个类。因此，归档源路径、前缀实际值及命令调用方传入的 `str/str2` 仍不能可靠解码。

### 当前结论与阻塞

提取方法本身及 Engine 包装层调用关系已由上传源码证实；**尚未证实它实际提取哪个归档、是否包含 OCR 字典**。下一步应优先在现有 JADX 导出结果中定位并导出 `I1I.I1I.p000IL.lIlii` 与 `I1I.IL1Iii` 两个类，以及触发 Engine 分发码 `42` 的调用点。暂不需要再次上传已存在的 Engine.java 或 m355L1l 方法。

