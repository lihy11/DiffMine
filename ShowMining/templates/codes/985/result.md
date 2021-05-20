###  infomation 
method del:
-java.lang.String.equalsIgnoreCase()
method add：
+java.lang.String.contains()
###  support count
project count : 5
commit count : 10
###  code
ProjectName: 48239-collect
CommitID: 9691f0e1bf62fe753e2cc594b87ec496e1c6e2c4
CommitMsg: Using 'maps placement-map' appearance has unexpected effect (#2260)


FilePath: collect_app/src/main/java/org/odk/collect/android/widgets/GeoPointWidget.java**
```diff
         useMapsV2 = useMapsV2(context);
-        if (appearance != null && appearance.equalsIgnoreCase("placement-map") && useMapsV2) {
+        if (appearance != null && appearance.toLowerCase(Locale.US).contains("placement-map") && useMapsV2) {
```
ProjectName: 48239-collect
CommitID: 9691f0e1bf62fe753e2cc594b87ec496e1c6e2c4
CommitMsg: Using 'maps placement-map' appearance has unexpected effect (#2260)


FilePath: collect_app/src/main/java/org/odk/collect/android/widgets/GeoPointWidget.java**
```diff
             useMaps = true;
-        } else if (appearance != null && appearance.equalsIgnoreCase("maps") && useMapsV2) {
+        } else if (appearance != null && appearance.toLowerCase(Locale.US).contains("maps") && useMapsV2) {
```
ProjectName: 35644-countly-sdk-android
CommitID: 4da13547fd36d8e6f98da00f1d09e7a82b01f4fc
CommitMsg: Allowing ECDHE_RSA

FilePath: sdk/src/main/java/ly/count/android/sdk/CertificateTrustManager.java**
```diff
 
-        if (!(null != authType && authType.equalsIgnoreCase("RSA"))) {
+        if (!(null != authType && authType.contains("RSA"))) {
```
ProjectName: 23130-webdrivermanager
CommitID: 534322ad0bdedf982b7dae2f36729e986cc5a367
CommitMsg: Bug-fix: specific version for Opera/Marionette

FilePath: src/main/java/io/github/bonigarcia/wdm/MarionetteDriverManager.java**
```diff
 		for (GitHubApi release : releaseArray) {
-			if (release.getName().equalsIgnoreCase(version)) {
+			if (release.getName().contains(version)) {
```
ProjectName: 10395-jitsi
CommitID: ad067de163699164e07a117fc291832225689492
CommitMsg: Corrects the discovery of IRC ChatRoomMemberRoles to be the same as in PircBot. Fixes a few raw-type warnings.

FilePath: src/net/java/sip/communicator/impl/protocol/irc/IrcStack.java**
```diff
 
-            if ("@".equalsIgnoreCase(userPrefix))
+            if (userPrefix.contains("@"))
```
ProjectName: 10395-jitsi
CommitID: ad067de163699164e07a117fc291832225689492
CommitMsg: Corrects the discovery of IRC ChatRoomMemberRoles to be the same as in PircBot. Fixes a few raw-type warnings.

FilePath: src/net/java/sip/communicator/impl/protocol/irc/IrcStack.java**
```diff
                 newMemberRole = ChatRoomMemberRole.ADMINISTRATOR;
-            else if ("%".equalsIgnoreCase(userPrefix))
+            else if (userPrefix.contains("%"))
```
ProjectName: 10395-jitsi
CommitID: ad067de163699164e07a117fc291832225689492
CommitMsg: Corrects the discovery of IRC ChatRoomMemberRoles to be the same as in PircBot. Fixes a few raw-type warnings.

FilePath: src/net/java/sip/communicator/impl/protocol/irc/IrcStack.java**
```diff
                 newMemberRole = ChatRoomMemberRole.MODERATOR;
-            else if ("+".equalsIgnoreCase(userPrefix))
+            else if (userPrefix.contains("+"))
```
ProjectName: 11281-liquibase
CommitID: 6e288036d61415c7afdabfd137cf33e2b1b3fb6c
CommitMsg: Fixed bug with schemaOutputAs option

FilePath: liquibase-core/src/main/java/liquibase/diff/output/changelog/AbstractChangeGenerator.java**
```diff
     private void setPropertyIgnoreSchemaAndCatalogCase(Change change, String field, String value, CompareControl.SchemaComparison comparison) {
-        if ("catalogName".equalsIgnoreCase(field)) {
+        if (field.toLowerCase().contains("catalogname")) {
```
ProjectName: 11281-liquibase
CommitID: 6e288036d61415c7afdabfd137cf33e2b1b3fb6c
CommitMsg: Fixed bug with schemaOutputAs option

FilePath: liquibase-core/src/main/java/liquibase/diff/output/changelog/AbstractChangeGenerator.java**
```diff
     private void setProperty(Change change, String field, String value, CompareControl.SchemaComparison comparison) {
-        if ("catalogName".equalsIgnoreCase(field)) {
+        if (field.toLowerCase().contains("catalogname")) {
```
ProjectName: 11281-liquibase
CommitID: 6860387b2f7c05d0475e49da451a7e27b4f82554
CommitMsg: handle smallmoney data types in mssql

git-svn-id: http://liquibase.jira.com/svn/CORE/trunk@981 e6edf6fb-f266-4316-afb4-e53d95876a76

FilePath: core/src/java/liquibase/database/structure/Column.java**
```diff
                 dataType = "DECIMAL";
-            } else if (database instanceof MSSQLDatabase && translatedTypeName.equalsIgnoreCase("money")) {
+            } else if (database instanceof MSSQLDatabase && translatedTypeName.toLowerCase().contains("money")) {
```
