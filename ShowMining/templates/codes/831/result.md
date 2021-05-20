###  infomation 
method del:
-java.lang.Boolean.valueOf()
method add：
+java.lang.Boolean.parseBoolean()
###  support count
project count : 9
commit count : 17
###  code
ProjectName: 23730-i2p.i2p
CommitID: 489f43529c222fa56213c321a0b0854ce74043be
CommitMsg: booleanValue() -> parseBoolean()

FilePath: core/java/src/net/i2p/I2PAppContext.java**
```diff
             return defaultVal;
-        return Boolean.valueOf(val).booleanValue();
+        return Boolean.parseBoolean(val);
```
ProjectName: 23730-i2p.i2p
CommitID: 489f43529c222fa56213c321a0b0854ce74043be
CommitMsg: booleanValue() -> parseBoolean()

FilePath: core/java/src/net/i2p/I2PAppContext.java**
```diff
     public boolean getBooleanProperty(String propName) {
-        return Boolean.valueOf(getProperty(propName)).booleanValue();
+        return Boolean.parseBoolean(getProperty(propName));
```
ProjectName: 14287-Saturn
CommitID: f73996faab9f28ffbd898b095dc97b05f52f8c37
CommitMsg: #97 fix sonar

FilePath: saturn-job-sharding/src/main/java/com/vip/saturn/job/sharding/task/AbstractAsyncShardingTask.java**
```diff
 					.forPath(jobConfigUseDispreferListNodePath);
-			if (useDispreferListData != null && !Boolean.valueOf(new String(useDispreferListData, "UTF-8"))) {
+			if (useDispreferListData != null && !Boolean.parseBoolean(new String(useDispreferListData, "UTF-8"))) {
```
ProjectName: 4948-spring-security
CommitID: 91c846756e5a0cc9e591c27fc6d5dbd7c1451a71
CommitMsg: Java 5: Unnecessary Boxing

FilePath: config/src/main/java/org/springframework/security/config/authentication/PasswordEncoderParser.java**
```diff
 		if (StringUtils.hasText(element.getAttribute(ATT_BASE_64))) {
-			useBase64 = Boolean.valueOf(element.getAttribute(ATT_BASE_64));
+			useBase64 = Boolean.parseBoolean(element.getAttribute(ATT_BASE_64));
```
ProjectName: 3296-ansj_seg
CommitID: 12772cd7b47da40643354d4be8ad2ee89fd9ec7c
CommitMsg: fix NLPchina/elasticsearch-analysis-ansj#160

FilePath: plugin/ansj_lucene7_plugin/src/main/java/org/ansj/lucene7/AnsjAnalyzer.java**
```diff
 		if (StringUtil.isNotBlank(temp = args.get("isRealName"))) { //是否保留原字符
-			analysis.setIsRealName(Boolean.valueOf(temp));
+			analysis.setIsRealName(Boolean.parseBoolean(temp));
```
ProjectName: 3296-ansj_seg
CommitID: 12772cd7b47da40643354d4be8ad2ee89fd9ec7c
CommitMsg: fix NLPchina/elasticsearch-analysis-ansj#160

FilePath: plugin/ansj_lucene5_plugin/src/main/java/org/ansj/lucene5/AnsjAnalyzer.java**
```diff
 		if (StringUtil.isNotBlank(temp = args.get("isRealName"))) { //是否保留原字符
-			analysis.setIsRealName(Boolean.valueOf(temp));
+			analysis.setIsRealName(Boolean.parseBoolean(temp));
```
ProjectName: 3296-ansj_seg
CommitID: 12772cd7b47da40643354d4be8ad2ee89fd9ec7c
CommitMsg: fix NLPchina/elasticsearch-analysis-ansj#160

FilePath: plugin/ansj_lucene6_plugin/src/main/java/org/ansj/lucene6/AnsjAnalyzer.java**
```diff
 		if (StringUtil.isNotBlank(temp = args.get("isRealName"))) { //是否保留原字符
-			analysis.setIsRealName(Boolean.valueOf(temp));
+			analysis.setIsRealName(Boolean.parseBoolean(temp));
```
ProjectName: 7606-opengrok
CommitID: 7bba4db4d753dfb9f7385c22d04350469988dc54
CommitMsg: Use parseXXX intead of valueOf

FilePath: src/org/opensolaris/opengrok/management/OGAgent.java**
```diff
         if (url.getProtocol().equals(RMI_PROTOCOL) &&
-                Boolean.valueOf(props.getProperty(RMI_START))) {
-            int rmiport = Integer.valueOf(props.getProperty(RMI_PORT));
+                Boolean.parseBoolean(props.getProperty(RMI_START))) {
+            int rmiport = Integer.parseInt(props.getProperty(RMI_PORT));
```
ProjectName: 3760-robolectric
CommitID: 46bc16c33e09f031bdedad17da1e2d6723b9952f
CommitMsg: Fix warnings.

FilePath: robolectric/src/main/java/org/robolectric/plugins/LegacyDependencyResolver.java**
```diff
     String dependencyDir = properties.getProperty("robolectric.dependency.dir");
-    if (dependencyDir != null || Boolean.valueOf(properties.getProperty("robolectric.offline"))) {
+    if (dependencyDir != null
+        || Boolean.parseBoolean(properties.getProperty("robolectric.offline"))) {
```
ProjectName: 5818-jmeter
CommitID: d63557edb5f1621e63bc4042c30fc30d570e228e
CommitMsg: Use parse instead of useless Wrappers

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1380856 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 9f05e86eb88ba1f73107c893fd9edbd30311458f
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/control/CookieManager.java**
```diff
                     }
-                    boolean secure = Boolean.valueOf(st[_secure]).booleanValue();
-                    long expires = Long.valueOf(st[_expires]).longValue();
+                    boolean secure = Boolean.parseBoolean(st[_secure]);
+                    long expires = Long.parseLong(st[_expires]);
```
ProjectName: 5818-jmeter
CommitID: 9f8f8c098e4c86e5c52f1150117e13d4a424b456
CommitMsg: use parseBoolean

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1380580 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 5fb7be9ba218e6928d45a084bacc84036488f8b6
FilePath: src/functions/org/apache/jmeter/functions/IterationCounter.java**
```diff
 
-        boolean perThread = Boolean.valueOf(((CompoundVariable) variables[0]).execute()).booleanValue();
+        boolean perThread = Boolean.parseBoolean(((CompoundVariable) variables[0]).execute());
```
ProjectName: 5818-jmeter
CommitID: 28d7ecf32e0a21f624ba0610a0511bbb93a6684e
CommitMsg: Remove useless null test
use parseBoolean

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1380366 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 2f07fb0140171a34255404ca19330212c5581079
FilePath: src/jorphan/org/apache/jorphan/util/Converter.java**
```diff
         }
-        return Boolean.valueOf(o.toString()).booleanValue();
+        return Boolean.parseBoolean(o.toString());
```
ProjectName: 5818-jmeter
CommitID: f8b02f617a6d8425575933ce23dd138bf3470c0b
CommitMsg: use parseBoolean instead of Wrapper creation

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1380320 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 340150a22db7d59cc85a4597395fa0492d0cab6b
FilePath: src/components/org/apache/jmeter/assertions/BeanShellAssertion.java**
```diff
             result.setFailureMessage(bshInterpreter.get("FailureMessage").toString());//$NON-NLS-1$
-            result.setFailure(Boolean.valueOf(bshInterpreter.get("Failure") //$NON-NLS-1$
-                    .toString()).booleanValue());
+            result.setFailure(Boolean.parseBoolean(bshInterpreter.get("Failure") //$NON-NLS-1$
+                    .toString()));
```
ProjectName: 5818-jmeter
CommitID: b2f156420785fafba9529fed75827e663507f9be
CommitMsg: Don't create Boolean when we want boolean

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1197236 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: cf4c0bbe9562a15cf0856d29cb6bdd9252fcdc66
FilePath: src/components/org/apache/jmeter/config/KeystoreConfig.java**
```diff
 
-        SSLManager.getInstance().configureKeystore(Boolean.valueOf(preload),
+        SSLManager.getInstance().configureKeystore(Boolean.parseBoolean(preload),
```
ProjectName: 8346-pmd
CommitID: 332773291e3b88860471f3cb6690f62edda31910
CommitMsg: PMD on PMD cleanup


git-svn-id: https://pmd.svn.sourceforge.net/svnroot/pmd/trunk@5000 51baf565-9d33-0410-a72c-fc3788e3496d

FilePath: pmd/src/net/sourceforge/pmd/cpd/JavaTokenizer.java**
```diff
     public void setProperties(Properties properties) {
-        ignoreLiterals = Boolean.valueOf(properties.getProperty(IGNORE_LITERALS, "false")).booleanValue();
-        ignoreIdentifiers = Boolean.valueOf(properties.getProperty(IGNORE_IDENTIFIERS, "false")).booleanValue();
+        ignoreLiterals = Boolean.parseBoolean(properties.getProperty(IGNORE_LITERALS, "false"));
+        ignoreIdentifiers = Boolean.parseBoolean(properties.getProperty(IGNORE_IDENTIFIERS, "false"));
```
ProjectName: 8346-pmd
CommitID: 332773291e3b88860471f3cb6690f62edda31910
CommitMsg: PMD on PMD cleanup


git-svn-id: https://pmd.svn.sourceforge.net/svnroot/pmd/trunk@5000 51baf565-9d33-0410-a72c-fc3788e3496d

FilePath: pmd/src/net/sourceforge/pmd/jsp/rules/AbstractJspRule.java**
```diff
     public boolean getBooleanProperty(String name) {
-        return Boolean.valueOf(properties.getProperty(name)).booleanValue();
+        return Boolean.parseBoolean(properties.getProperty(name));
```
ProjectName: 38627-presto
CommitID: 75ffecaf12078ef3e1a64eff4bad3d76447eceb2
CommitMsg: Get rid of unnecessary boxing/unboxing

FilePath: presto-main/src/main/java/com/facebook/presto/type/TypeJsonUtils.java**
```diff
         if (type.getJavaType() == boolean.class) {
-            type.writeBoolean(blockBuilder, Boolean.valueOf(jsonKey));
+            type.writeBoolean(blockBuilder, Boolean.parseBoolean(jsonKey));
```
