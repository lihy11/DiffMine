###  infomation 
method del:
-java.lang.String.replaceAll()
method add：
+java.util.regex.Matcher.replaceAll()
+java.util.regex.Pattern.matcher()
###  support count
project count : 11
commit count : 13
###  code
ProjectName: 23045-UniversalMediaServer
CommitID: 912f672590bcd15e46d95eb71f859c76ac8eb50c
CommitMsg: Optimized regex and changed wording for consistency

FilePath: src/main/java/net/pms/util/SubtitleUtils.java**
```diff
 		while ((line = input.readLine()) != null) {
-			line = line.replaceAll("\\</?(?:b|i|s|u|font[^\\>]*)\\>|\\{\\\\[^\\}]+\\}|\\\\h|\\\\N","") + "\n";
+			line = pattern.matcher(line).replaceAll("") + "\n";
```
ProjectName: 25470-gravitee-gateway
CommitID: 8b38e48ce68a191ccbfd466e81a0db6b675936b6
CommitMsg: don't compile a regex for each invoke (#97)

reuse the compiled pattern
FilePath: gravitee-gateway-http-client/gravitee-gateway-http-client-core/src/main/java/io/gravitee/gateway/http/core/invoker/AbstractHttpInvoker.java**
```diff
         // Remove duplicate slash
-        sEndpoint = sEndpoint.replaceAll("(?<!(http:|https:))[//]+", "/");
+        sEndpoint = DUPLICATE_SLASH_REMOVER.matcher(sEndpoint).replaceAll("/");
```
ProjectName: 10502-java-string-similarity
CommitID: 2b2930e1f500efd5f9efbd95891a62ab7da3a818
CommitMsg: Merge origin/master

Conflicts:
	src/main/java/info/debatty/java/stringsimilarity/KShingling.java

FilePath: src/main/java/info/debatty/java/stringsimilarity/KShingling.java**
```diff
     public boolean parse(String s) {
-        s = s.replaceAll("\\s+", " ");
+        s = spaceReg.matcher(s).replaceAll(" ");
```
ProjectName: 15118-spring-cloud-config
CommitID: ccd3bc2ff6d7e61f1eb88c1a25f836b09447993a
CommitMsg: Refactor String#replaceAll (#1146)

If we repeatedly call String#replaceAll, we internally repeatedly call the regular expression pattern compilation every time as following:

```java
    public String replaceAll(String regex, String replacement) {
        return Pattern.compile(regex).matcher(this).replaceAll(replacement);
    }
```
The modifications are to keep the compiled pattern.
Therefore, compiling a relatively expensive regular expression pattern does not have to be done every time.
FilePath: spring-cloud-config-server/src/main/java/org/springframework/cloud/config/server/support/GitSkipSslValidationCredentialsProvider.java**
```diff
 	private static String stripFormattingPlaceholders(String string) {
-		return string.replaceAll("\\s*\\{\\d}\\s*", "");
+		return FORMAT_PLACEHOLDER_PATTERN.matcher(string).replaceAll("");
```
ProjectName: 2042-jsoup
CommitID: f0f3eab9c34cc32c6ad06a991fe572d243ca9e85
CommitMsg: TextNode performance tweaks

FilePath: src/main/java/org/jsoup/nodes/TextNode.java**
```diff
     static String normaliseWhitespace(String text) {
-        text = text.replaceAll("\\s{2,}|(\\r\\n|\\r|\\n)", " "); // more than one space, and newlines to " "
+        text = spaceNormaliser.matcher(text).replaceAll(" "); // more than one space, and newlines to " "
```
ProjectName: 3683-checkstyle
CommitID: 738c7f184d7e8b7c9d11dcb3cc47e0895945d1e3
CommitMsg: Use compiled pattern instead of dynamic regexp. #1555

Fixes `DynamicRegexReplaceableByCompiledPattern` inspection violations.

Description:
>Reports calls to the regular expression methods of java.lang.String using constants arguments. Such calls may be profitably replaced with a private static final Pattern field so that the regular expression does not have to be compiled each time it is used.

FilePath: src/main/java/com/puppycrawl/tools/checkstyle/checks/OuterTypeFilenameCheck.java**
```diff
         fname = fname.substring(fname.lastIndexOf(File.separatorChar) + 1);
-        fname = fname.replaceAll("\\.[^\\.]*$", "");
+        fname = FILE_EXTENSION_PATTERN.matcher(fname).replaceAll("");
```
ProjectName: 3683-checkstyle
CommitID: 7b14802231d6031a6b31565328dc0ddd80c7d2c6
CommitMsg: Use compiled pattern instead of dynamic regexp. #1555

Fixes some `SpellDynamicRegexReplaceableByCompiledPattern` inspection violations.

Description:
>Reports calls to the regular expression methods of java.lang.String using constants arguments. Such calls may be profitably replaced with a private static final Pattern field so that the regular expression does not have to be compiled each time it is used.

FilePath: src/main/java/com/puppycrawl/tools/checkstyle/checks/header/AbstractHeaderCheck.java**
```diff
 
-        final String headerExpandedNewLines = header.replaceAll("\\\\n", "\n");
+        final String headerExpandedNewLines = ESCAPED_LINE_FEED_PATTERN
+                .matcher(header).replaceAll("\n");
```
ProjectName: 9433-graphhopper
CommitID: b9c6af3f3f7665f685591cd78f3780793f73cf05
CommitMsg: Use precompiled Pattern instances (#1789)


FilePath: core/src/main/java/com/graphhopper/routing/util/EncodingManager.java**
```diff
             return "";
-        return str.replaceAll(";[ ]*", ", ");
+        return WAY_NAME_PATTERN.matcher(str).replaceAll(", ");
```
ProjectName: 5844-jOOQ
CommitID: 2268afa4ab4322f14db97c8b9d5eecceb37ab578
CommitMsg: [#2011] Implement some micro-optimisations in DefaultRenderContext - 2.
Regular expression usage for indentation
FilePath: jOOQ/src/main/java/org/jooq/impl/DefaultRenderContext.java**
```diff
         if (s != null && cachedRenderFormatted) {
-            sql.append(s.replaceAll("[\\n\\r]", "$0" + indentation()));
+            sql.append(NEWLINE.matcher(s).replaceAll("$0" + indentation()));
```
ProjectName: 5844-jOOQ
CommitID: 58f57c9f1afc6585b7aaa1b83fbd06295340f478
CommitMsg: [#1635] Improve the performance of Factory.fetch(ResultSet) by caching
data type normalisation regex in FieldTypeHelper
FilePath: jOOQ/src/main/java/org/jooq/impl/FieldTypeHelper.java**
```diff
     public static String normalise(String typeName) {
-        return typeName.toUpperCase().replaceAll("\"|\\.|\\s|\\(\\w+(,\\w+)*\\)|(NOT\\s*NULL)?", "");
+        return NORMALISE_PATTERN.matcher(typeName.toUpperCase()).replaceAll("");
```
ProjectName: 2454-cas
CommitID: c4e24448048f9f9299ae423c2807542f206be178
CommitMsg: small perf improvements with regex patterns

FilePath: core/cas-server-core-services-api/src/main/java/org/apereo/cas/services/util/JasigRegisteredServiceDeserializationProblemHandler.java**
```diff
         if (subTypeId.contains("org.jasig.")) {
-            val newTypeName = subTypeId.replaceAll("jasig", "apereo");
+            val newTypeName = PATTERN_JASIG_NAMESPACE.matcher(subTypeId).replaceAll("apereo");
```
ProjectName: 6424-hbase
CommitID: aef674264ec0262cddc901182dcd3d1b7851b2e1
CommitMsg: HBASE-18281 created private static pattern matcher for performance

Signed-off-by: tedyu <yuzhihong@gmail.com>

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/regionserver/StoreFileWriter.java**
```diff
     }
-    return new Path(dir, UUID.randomUUID().toString().replaceAll("-", ""));
+    return new Path(dir, dash.matcher(UUID.randomUUID().toString()).replaceAll(""));
```
ProjectName: 5818-jmeter
CommitID: 179d6a813cf24739218c5ad9f700b715c51df716
CommitMsg: Bug 52886 - Proxy : Recording issues with HTTPS when spoofing is on, secure cookies are not always changed

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1299631 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 945cf9d367bf814d80c6e45153f692910c1ccc4f
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/proxy/Proxy.java**
```diff
                 {
-                    headerLines[i]=headerLines[i].replaceAll(" secure", "").trim(); //in forced https cookies need to be unsecured...
+                    headerLines[i]=COOKIE_SECURE_PATTERN.matcher(headerLines[i]).replaceAll("").trim(); //in forced https cookies need to be unsecured...
```
