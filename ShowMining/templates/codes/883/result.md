###  infomation 
method del:
-java.lang.StringBuffer.append()
method add：
+java.lang.StringBuilder.append()
###  support count
project count : 12
commit count : 22
###  code
ProjectName: 30369-android-obd-reader
CommitID: 628d6fe89f644a9e86a38bad5c8f81fae344cd12
CommitMsg: Fixes #139.

FilePath: src/main/java/com/github/pires/obd/reader/activity/MainActivity.java**
```diff
                     sb.append(" Alt: ");
-                    sb.append(String.valueOf(mLastLocation.getAltitude()).substring(0, posLen));
+                    sb.append(String.valueOf(mLastLocation.getAltitude()));
```
ProjectName: 33715-openhtmltopdf
CommitID: cdc71cc1b5c894000f680a970bb9ed7a1efc1f44
CommitMsg: Replaced StringBuffer with StringBuilder

FilePath: openhtmltopdf-core/src/main/java/com/openhtmltopdf/css/newmatch/CascadedStyle.java**
```diff
         if (this.fingerprint == null) {
-            StringBuffer sb = new StringBuffer();
-            Iterator iter = cascadedProperties.values().iterator();
-            while (iter.hasNext()) {
-                sb.append(((PropertyDeclaration)iter.next()).getFingerprint());
+            StringBuilder sb = new StringBuilder();
+            for (Object o : cascadedProperties.values()) {
+                sb.append(((PropertyDeclaration) o).getFingerprint());
```
ProjectName: 36183-java-cas-client
CommitID: ec87c31ecdedfaafa64861bcfa3071cb1441b37e
CommitMsg: NOJIRA

switch to stringbuilder since we're on Java 5

FilePath: cas-client-core/src/main/java/org/jasig/cas/client/util/XmlUtils.java**
```diff
                 if (this.foundElement) {
-                    buffer.append(ch, start, length);
+                    builder.append(ch, start, length);
```
ProjectName: 22223-pdfbox
CommitID: ff0d04e1c9cfa4db039be1b6fcd9c49527b259ee
CommitMsg: PDFBOX-2576: use StringBuilder; replace string concat with .append chain; fix javadoc

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1684465 13f79535-47bb-0310-9956-ffa450edef68

FilePath: tools/src/main/java/org/apache/pdfbox/tools/PDFText2HTML.java**
```diff
         buf.append("<html><head>");
-        buf.append("<title>" + escape(getTitle()) + "</title>\n");
+        buf.append("<title>").append(escape(getTitle())).append("</title>\n");
```
ProjectName: 26998-rabbitmq-java-client
CommitID: 4c606d4a5e6ed398ef70a84e352dc68594706131
CommitMsg: Revert change to Appendable - much cleaner with StringBuilder

FilePath: src/com/rabbitmq/client/impl/AMQContentHeader.java**
```diff
     /** Public API - {@inheritDoc} */
-    public void appendPropertyDebugStringTo(Appendable acc) {
-        try { acc.append("(?)"); } catch(IOException ioe) { }
+    public void appendPropertyDebugStringTo(StringBuilder acc) {
+        acc.append("(?)");
```
ProjectName: 26998-rabbitmq-java-client
CommitID: 4c606d4a5e6ed398ef70a84e352dc68594706131
CommitMsg: Revert change to Appendable - much cleaner with StringBuilder

FilePath: src/com/rabbitmq/client/impl/Method.java**
```diff
      */
-    public void appendArgumentDebugStringTo(Appendable buffer) {
-        try { buffer.append("(?)");} catch(IOException ioe) { }
+    public void appendArgumentDebugStringTo(StringBuilder buffer) {
+        buffer.append("(?)");
```
ProjectName: 10572-Openfire
CommitID: 0751edb3f542e6d3478b9d6fc68c87a59e79f060
CommitMsg: Merge pull request #328 from sco0ter/stringbuffer

Replace StringBuffer with StringBuilder (for performance).
FilePath: src/java/org/jivesoftware/util/StringUtils.java**
```diff
         if (numHours > 0) {
-            buf.append(numHours + " " + HOURS + ", ");
+            buf.append(numHours).append(' ').append(HOURS).append(", ");
```
ProjectName: 10572-Openfire
CommitID: 0751edb3f542e6d3478b9d6fc68c87a59e79f060
CommitMsg: Merge pull request #328 from sco0ter/stringbuffer

Replace StringBuffer with StringBuilder (for performance).
FilePath: src/java/org/jivesoftware/util/StringUtils.java**
```diff
         if (numMinutes > 0) {
-            buf.append(numMinutes + " " + MINUTES);
+            buf.append(numMinutes).append(' ').append(MINUTES);
```
ProjectName: 10572-Openfire
CommitID: 5094bbe3247fc51f03f999339cd6ae1571a9d7f4
CommitMsg: Replace StringBuffer with StringBuilder (for performance).

And don't use String concatenation within the append() method.

FilePath: src/java/org/jivesoftware/util/StringUtils.java**
```diff
         if (numHours > 0) {
-            buf.append(numHours + " " + HOURS + ", ");
+            buf.append(numHours).append(' ').append(HOURS).append(", ");
```
ProjectName: 10572-Openfire
CommitID: 5094bbe3247fc51f03f999339cd6ae1571a9d7f4
CommitMsg: Replace StringBuffer with StringBuilder (for performance).

And don't use String concatenation within the append() method.

FilePath: src/java/org/jivesoftware/util/StringUtils.java**
```diff
         if (numMinutes > 0) {
-            buf.append(numMinutes + " " + MINUTES);
+            buf.append(numMinutes).append(' ').append(MINUTES);
```
ProjectName: 4291-joda-time
CommitID: 66c4a1c10d33243fb0a6f850d350226ab4d55a6c
CommitMsg: Change some StringBuffer uses to StringBuilder [3532330]

FilePath: src/main/java/org/joda/time/tz/ZoneInfoProvider.java**
```diff
             if (in == null) {
-                StringBuffer buf = new StringBuffer(40)
+                StringBuilder buf = new StringBuilder(40)
```
ProjectName: 4291-joda-time
CommitID: 66c4a1c10d33243fb0a6f850d350226ab4d55a6c
CommitMsg: Change some StringBuffer uses to StringBuilder [3532330]

FilePath: src/main/java/org/joda/time/IllegalFieldValueException.java**
```diff
                                         Number lowerBound, Number upperBound, String explain) {
-        StringBuffer buf = new StringBuffer()
+        StringBuilder buf = new StringBuilder()
```
ProjectName: 2574-antlr4
CommitID: 57eb76aab3e54835868678b328adedf41704a030
CommitMsg: v4: StringBuilder instead of StringBuffer

[git-p4: depot-paths = "//depot/code/antlr4/main/": change = 9357]

FilePath: runtime/Java/src/org/antlr/v4/runtime/atn/ATNConfig.java**
```diff
 		if ( reachesIntoOuterContext>0 ) {
-			buf.append("|up="+reachesIntoOuterContext);
+			buf.append("|up=").append(reachesIntoOuterContext);
```
ProjectName: 4607-hibernate-orm
CommitID: c6db5cfdcbc4fa48702e702a417cde70a1e9b19c
CommitMsg: HHH-4943

FilePath: hibernate-core/src/main/java/org/hibernate/dialect/FirebirdDialect.java**
```diff
 	public String getLimitString(String sql, boolean hasOffset) {
-		return new StringBuffer( sql.length() + 20 )
+		return new StringBuilder( sql.length() + 20 )
```
ProjectName: 4607-hibernate-orm
CommitID: c6db5cfdcbc4fa48702e702a417cde70a1e9b19c
CommitMsg: HHH-4943

FilePath: hibernate-core/src/main/java/org/hibernate/dialect/InterbaseDialect.java**
```diff
 	public String getLimitString(String sql, boolean hasOffset) {
-		return new StringBuffer( sql.length()+15 )
+		return new StringBuilder( sql.length()+15 )
```
ProjectName: 4607-hibernate-orm
CommitID: 3b8678864a9e609ba0a8c55fe354f62f0b38591e
CommitMsg: HHH-6242 no Types.BINARY type mapping in PostgresqlDialect

FilePath: hibernate-core/src/main/java/org/hibernate/engine/internal/Nullability.java**
```diff
 	private static String buildPropertyPath(String parent, String child) {
-		return new StringBuffer( parent.length() + child.length() + 1 )
+		return new StringBuilder( parent.length() + child.length() + 1 )
```
ProjectName: 8346-pmd
CommitID: d2b5f2552454726cc81208f092e19fa1e34c888d
CommitMsg: minor cleanup

git-svn-id: https://pmd.svn.sourceforge.net/svnroot/pmd/trunk@7466 51baf565-9d33-0410-a72c-fc3788e3496d

FilePath: pmd/src/net/sourceforge/pmd/util/StringUtil.java**
```diff
              java.util.Arrays.fill(arr, ' ');
-             res = new StringBuffer(length).append(arr).append(s).toString();
+             res = new StringBuilder(length).append(arr).append(s).toString();
```
ProjectName: 8346-pmd
CommitID: a85a9cd3c5818fad345e6fd725135c8fe1d79d06
CommitMsg: StringBuffer -> StringBuilder switchovers

git-svn-id: https://pmd.svn.sourceforge.net/svnroot/pmd/trunk@7331 51baf565-9d33-0410-a72c-fc3788e3496d

FilePath: pmd/src/net/sourceforge/pmd/cpd/VSRenderer.java**
```diff
                 buffer.append(mark.getTokenSrcID());
-                buffer.append("(" + mark.getBeginLine() +"):");
+                buffer.append('(').append(mark.getBeginLine()).append("):");
```
ProjectName: 389-fastjson
CommitID: 3ac9038612054de234341180123ccc04000b9080
CommitMsg: Merge branch 'master' of https://github.com/alibaba/fastjson

FilePath: src/main/java/com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer.java**
```diff
                 
-                StringBuffer buf = (new StringBuffer()) //
+                StringBuilder buf = (new StringBuilder()) //
```
ProjectName: 389-fastjson
CommitID: 41c1097013a51011385430ab138a422a6c9324d7
CommitMsg: Merge pull request #2008 from wxisme/patch-1

Use StringBuilder instead of StringBuffer.
FilePath: src/main/java/com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer.java**
```diff
                 
-                StringBuffer buf = (new StringBuffer()) //
+                StringBuilder buf = (new StringBuilder()) //
```
ProjectName: 389-fastjson
CommitID: 26ea1d6b6d7af9c0adb18a6cb43679d7dd857c0a
CommitMsg: Use StringBuilder instead of StringBuffer.

FilePath: src/main/java/com/alibaba/fastjson/parser/deserializer/JavaBeanDeserializer.java**
```diff
                 
-                StringBuffer buf = (new StringBuffer()) //
+                StringBuilder buf = (new StringBuilder()) //
```
ProjectName: 568-libgdx
CommitID: c49c6122a9984bd3d2b2b3a433bf8b1247c475c5
CommitMsg: Use StringBuilder instead of StringBuffer (#5063)


FilePath: backends/gdx-backend-android/src/com/badlogic/gdx/backends/android/AndroidInput.java**
```diff
 		for (int i = 0; i < len; i++) {
-			buf.append(i + ":" + realId[i] + " ");
+			sb.append(i + ":" + realId[i] + " ");
```
