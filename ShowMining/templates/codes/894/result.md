###  infomation 
method del:
-java.lang.String.replace()
method add：
+java.lang.String.replaceFirst()
###  support count
project count : 11
commit count : 15
###  code
ProjectName: 20514-apps-android-wikipedia
CommitID: 736541996dc241592506cff821318c93f574f548
CommitMsg: Don't break when clicking an internal link to a page title containing '/wiki/'

We shouldn't be checking anything for '/wiki/' anyway, but this will do for now

Bug: 67949
Change-Id: I6d83c2e9e40724993bb13cea248ac672d3cea734

FilePath: wikipedia/src/main/java/org/wikipedia/Site.java**
```diff
         // FIXME: Handle language variant links properly
-        return new PageTitle(internalLink.replace("/wiki/", ""), this);
+        return new PageTitle(internalLink.replaceFirst("/wiki/", ""), this);
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 715073e209408caa231df531ba68cc645eb43be6
CommitMsg: Hit the API on an mdot subdomain instead of a desktop subdomain.

* Wikipedia Zero extension API eligibility check is on mdot for foreseeable future.
* API behavior generally the same otherwise, so mdot is okay instead of desktop URL.
* Other aspects of the system still use the originally provided desktop domain.

Change-Id: Ic35ebe02c1abfa11059b52b6cddf94a00f09727f

FilePath: wikipedia/src/main/java/org/wikipedia/Site.java**
```diff
 
-    protected String normalizeDomainName(String domain) {
-        return domain.replace(".m.", ".");
+    protected String getApiDomain() {
+        return domain.replaceFirst("\\.", ".m.");
```
ProjectName: 21302-phpinspectionsea
CommitID: b74ea4b244272f1ca1e7dca531c0e676395af7f0
CommitMsg: [#189] RealpathInSteamContextInspector: bug-fix

FilePath: src/main/java/com/kalessil/phpStorm/phpInspectionsEA/inspectors/apiUsage/fileSystem/RealpathInSteamContextInspector.java**
```diff
                     while (newRight.startsWith("/..")) {
-                        newRight = newRight.replace("/..", "");
+                        newRight = newRight.replaceFirst("/\\.\\.", "");
```
ProjectName: 10166-Anki-Android
CommitID: eb9fe5159a4d98697e30dc71165b3b1791cdeab1
CommitMsg: Issue2424 {{FrontSide}} audio
Only remove the first instance of {{FrontSide} audio from the back audio

FilePath: AnkiDroid/src/main/java/com/ichi2/anki/AbstractFlashcardViewer.java**
```diff
             Matcher audioReferences = Sound.sSoundPattern.matcher(frontSideFormat);
-            while (audioReferences.find()) {
-                answerContent = answerContent.replace(audioReferences.group(), "");
+            // remove the first instance of audio contained in "{{FrontSide}}"
+            if (audioReferences.find()) {
+                answerContent = answerContent.replaceFirst(audioReferences.group(), "");
```
ProjectName: 10166-Anki-Android
CommitID: 9c3ffa0b80ab4ffa7e19907a4a09128dea669489
CommitMsg: fix bug when renaming foo::bar foo to new parent (dae/old-libanki 4a00e0427)

FilePath: src/com/ichi2/libanki/Decks.java**
```diff
                     String on = grp.getString("name");
-                    String nn = on.replace(oldName + "::", newName + "::");
+                    // unlike the related code in libanki python the following replaceFirst call works with regex
+                    // pattern, so we need to escape the oldName:: with \Q, \E
+                    String nn = on.replaceFirst("\\Q" + oldName + "::\\E", newName + "::");
```
ProjectName: 12637-FolioReader-Android
CommitID: 770ec1a155490e4dd6dcee64a0c9d58d9a86ab09
CommitMsg: #30 highlight redundancy in unicode books

FilePath: folioreader/src/main/java/com/folioreader/fragments/FolioPageFragment.java**
```diff
                     "" + highlight.getContent() + "" + highlight.getContentPost();
-            htmlContent = htmlContent.replace(searchStr, highlightStr);
+            htmlContent = htmlContent.replaceFirst(searchStr, highlightStr);
```
ProjectName: 17859-docker-maven-plugin
CommitID: 5b49b3c55c7dab5db959c62d8e7b00f6b7225d61
CommitMsg: small fix + updated docs

----------------------
branch [[build-args-from-outside]]

FilePath: src/main/java/io/fabric8/maven/docker/AbstractBuildSupportMojo.java**
```diff
             if (key.startsWith(argPrefix)){
-                String argKey = key.replace(argPrefix, "");
+                String argKey = key.replaceFirst(argPrefix, "");
```
ProjectName: 17859-docker-maven-plugin
CommitID: 055fee27bd1832d960ba01aebb06ea77d3bff6c9
CommitMsg: Fix replacement of docker host URLs starting with "tcp". Fixes #28

FilePath: src/main/java/org/jolokia/docker/maven/AbstractDockerMojo.java**
```diff
             colorInit();
-            DockerAccess access = new DockerAccessUnirest(url.replace("^tcp://", "http://"), this);
+            DockerAccess access = new DockerAccessUnirest(url.replaceFirst("^tcp:", "http:"), this);
```
ProjectName: 11281-liquibase
CommitID: f74f2d3d09cd9e36db87e8250c49d0f28469b029
CommitMsg: Fixed tests

git-svn-id: http://liquibase.jira.com/svn/CORE/trunk@22 e6edf6fb-f266-4316-afb4-e53d95876a76

FilePath: src/java/liquibase/migrator/change/CreateTableChange.java**
```diff
         if (fkConstraints.length() > 0) {
-            buffer.append(", ").append(fkConstraints.toString().replace(",$",""));
+            buffer.append(", ").append(fkConstraints.toString().replaceFirst(",$",""));
```
ProjectName: 6217-FEBS-Shiro
CommitID: 76ea8062ff650d1db11831a9f4d1dc83a99eb14a
CommitMsg: Merge pull request #97 from gelibo/v2.0

issue#96相关问题
FilePath: src/main/java/cc/mrbird/febs/generator/controller/GeneratorController.java**
```diff
             if (GeneratorConfig.TRIM_YES.equals(generatorConfig.getIsTrim())) {
-                className = name.replace(generatorConfig.getTrimValue(), "");
+                className = name.replaceFirst(generatorConfig.getTrimValue(), "");
```
ProjectName: 6217-FEBS-Shiro
CommitID: fb276ec10f47449cb19b2d02464eeaa8d713af7b
CommitMsg: Update GeneratorController.java

代码生成时bug修改
FilePath: src/main/java/cc/mrbird/febs/generator/controller/GeneratorController.java**
```diff
             if (GeneratorConfig.TRIM_YES.equals(generatorConfig.getIsTrim())) {
-                className = name.replace(generatorConfig.getTrimValue(), "");
+                className = name.replaceFirst(generatorConfig.getTrimValue(), "");
```
ProjectName: 5607-atmosphere
CommitID: 63b098d014eebb98a5e7e985b20c900fd923a9d6
CommitMsg: Fix for http://java.net/jira/browse/ATMOSPHERE-108
("The AtmosphereServlet does not handle properly classes loaded "mvn jetty:run"")

Pathc provided by rostislav

FilePath: modules/cpr/src/main/java/org/atmosphere/cpr/AtmosphereServlet.java**
```diff
                     className = className.replace('\\', '/');
-                    className = className.substring(className.indexOf(WEB_INF_CLASSES)
-                            + WEB_INF_CLASSES.length(), className.lastIndexOf(".")).replace('/', '.');
+                    className = className.replaceFirst("^.*/(WEB-INF|target)/(test-)?classes/(.*)\\.class", "$3");
```
ProjectName: 13675-framework
CommitID: 3cb61fb9371d81f2d3d7a51fb9f12348ef5c4fd5
CommitMsg: JDK 1.4.x compatibility fix. Code did not work on JDK 1.4.x.

svn changeset:1279/svn branch:trunk

FilePath: src/com/itmill/toolkit/terminal/web/ApplicationServlet.java**
```diff
 							&& !isDebugMode(unhandledParameters)) {
-						file = file.replace("bug.js", "bugx.js");
+						file = file.replaceFirst("bug.js", "bugx.js");
```
ProjectName: 48895-azure-sdk-for-java
CommitID: ba3e0f3f327700460d2cb5948f82c72081ef7229
CommitMsg: Only replace sb:// at start of connection string value

FilePath: microsoft-azure-api/src/main/java/com/microsoft/windowsazure/services/serviceBus/implementation/ServiceBusConnectionSettings.java**
```diff
     private void setUri(ServiceBusConnectionString connectionString) {
-        uri = connectionString.getEndpoint().replace("sb://", "https://");
+        uri = connectionString.getEndpoint().replaceFirst("^sb://", "https://");
```
ProjectName: 259-zxing
CommitID: 5a077832241eee11c62d9b15e3b7990197e01875
CommitMsg: Issue #142 : fix escaping of %f / %t

FilePath: android/src/com/google/zxing/client/android/result/ResultHandler.java**
```diff
       // problematic but avoids the more surprising problem of breaking escapes
-      url = url.replace("%f(?![0-9a-f])", rawResult.getBarcodeFormat().toString());
+      url = url.replaceFirst("%f(?![0-9a-f])", rawResult.getBarcodeFormat().toString());
```
