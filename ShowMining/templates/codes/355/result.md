###  infomation 
method del:
-java.sql.ResultSetMetaData.getColumnName()
method add：
+java.sql.ResultSetMetaData.getColumnLabel()
###  support count
project count : 9
commit count : 13
###  code
ProjectName: 33465-sqoop
CommitID: e2d6499da8567888989908ddcd078f046e859679
CommitMsg: SQOOP-585: Bug when sqoop a join of two tables with the same column name with mysql backend

(Amit Sela via Jarek Jarcec Cecho)

FilePath: src/java/org/apache/sqoop/util/ResultSetPrinter.java**
```diff
       for (int i = 1; i < cols + 1; i++) {
-        String colName = metadata.getColumnName(i);
+        String colName = metadata.getColumnLabel(i);
```
ProjectName: 21374-psi-probe
CommitID: c263dbaa2f944fd54c056f056972aa829161eb6a
CommitMsg: Update issue 250
Changing getColumnName to getColumnLabel, which falls back to the column name if none is defined, so SQL "AS" works consistently.  (Thanks to maelstro for your contribution!)

FilePath: core/src/main/java/com/googlecode/psiprobe/controllers/sql/ExecuteSqlController.java**
```diff
 
-                                        record.put(HtmlUtils.htmlEscape(metaData.getColumnName(i)), value);
+                                        record.put(HtmlUtils.htmlEscape(metaData.getColumnLabel(i)), value);
```
ProjectName: 25999-geotools
CommitID: d948067f5cc024fa238d9011f1af4c8737e97945
CommitMsg: GEOT-4500 Virtual table metadata does not work for column aliases

FilePath: modules/library/jdbc/src/main/java/org/geotools/jdbc/JDBCFeatureSource.java**
```diff
                 ColumnMetadata column = new ColumnMetadata();
-                column.name = metadata.getColumnName(i);
+                column.name = metadata.getColumnLabel(i);
```
ProjectName: 26200-mondrian
CommitID: 95a28d5314f3cc2984472c8a9c1e1566898d1baf
CommitMsg: MONDRIAN: Re-apply fix to bug 1592556, "XMLA Drill through bug", which I originally fixed in change 8110 but accidentally paved over in change 8657.

[git-p4: depot-paths = "//open/mondrian/": change = 10188]

FilePath: src/main/mondrian/xmla/XmlaHandler.java**
```diff
                 for (int i = 0; i < columnCount; i++) {
-                    headers[i] = md.getColumnName(i + 1);
+                    headers[i] = md.getColumnLabel(i + 1);
```
ProjectName: 10256-traccar
CommitID: d31cb022e5cd75bee3a82d8fe2d2f00806146232
CommitMsg: Fix column label problem

FilePath: src/org/traccar/database/QueryBuilder.java**
```diff
                         for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {
-                            if (name.equalsIgnoreCase(resultMetaData.getColumnName(i))) {
+                            if (name.equalsIgnoreCase(resultMetaData.getColumnLabel(i))) {
```
ProjectName: 11281-liquibase
CommitID: e219b2aa211543656fb834f47bb05206b6a380eb
CommitMsg: Merge remote-tracking branch 'origin/master'

FilePath: liquibase-core/src/main/java/liquibase/executor/jvm/ColumnMapRowMapper.java**
```diff
         for (int i = 1; i <= columnCount; i++) {
-            String key = getColumnKey(rsmd.getColumnName(i));
+            String key = getColumnKey(rsmd.getColumnLabel(i));
```
ProjectName: 11281-liquibase
CommitID: d06613642c09041b2701b573f226555d061e998d
CommitMsg: Merge pull request #94 from vorbis/h2ColumnFix

Added fix for reading column size in H2.
FilePath: liquibase-core/src/main/java/liquibase/executor/jvm/ColumnMapRowMapper.java**
```diff
         for (int i = 1; i <= columnCount; i++) {
-            String key = getColumnKey(rsmd.getColumnName(i));
+            String key = getColumnKey(rsmd.getColumnLabel(i));
```
ProjectName: 11281-liquibase
CommitID: 774981720b7584f688b047a57605a78aa59de6c8
CommitMsg: Made ColumnMapRowMapper respect SELECT AS column labels
FilePath: liquibase-core/src/main/java/liquibase/executor/jvm/ColumnMapRowMapper.java**
```diff
         for (int i = 1; i <= columnCount; i++) {
-            String key = getColumnKey(rsmd.getColumnName(i));
+            String key = getColumnKey(rsmd.getColumnLabel(i));
```
ProjectName: 11281-liquibase
CommitID: f0fc4651654e379a1f1bfee77b4fa9ae38f2b97b
CommitMsg: Added fix for reading column size in H2.

On my Ubuntu box, H2 sets the column name for the size of a column to CHARACTER_MAXIMUM_LENGTH and the label to COLUMN_SIZE.
When  mapping columns I think in general we should use the column label and not the column name.
The column label will fall back to the name if no label is specified. If one is specified then typically it's specified for a reason (standards compatibility).

Removed old h2 jar from database test drivers.

FilePath: liquibase-core/src/main/java/liquibase/executor/jvm/ColumnMapRowMapper.java**
```diff
         for (int i = 1; i <= columnCount; i++) {
-            String key = getColumnKey(rsmd.getColumnName(i));
+            String key = getColumnKey(rsmd.getColumnLabel(i));
```
ProjectName: 8212-immutables
CommitID: bbef3441b9c0993b09e30f5000b5c19c172f11fb
CommitMsg: fix to be able to map to `as name` columns names
FilePath: common/src/org/immutables/common/jdbi/MapperFactory.java**
```diff
         int i = j + 1;
-        String name = toLowerCamel(metaData.getColumnName(i));
+        String name = toLowerCamel(metaData.getColumnLabel(i));
```
ProjectName: 5818-jmeter
CommitID: 76a776f9f412cb5e685b8ef7623a70e9dc317ac7
CommitMsg: Bug 46932 - Alias given in select statement is not used as column header in response data for a JDBC request
Bugzilla Id: 46932

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1597469 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 42847fd2ceea42c53ff9f25b9281a308f94068be
FilePath: src/protocol/jdbc/org/apache/jmeter/protocol/jdbc/AbstractJDBCTestElement.java**
```diff
         for (int i = 1; i <= numColumns; i++) {
-            sb.append(meta.getColumnName(i));
+            sb.append(meta.getColumnLabel(i));
```
ProjectName: 5818-jmeter
CommitID: 76a776f9f412cb5e685b8ef7623a70e9dc317ac7
CommitMsg: Bug 46932 - Alias given in select statement is not used as column header in response data for a JDBC request
Bugzilla Id: 46932

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1597469 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 42847fd2ceea42c53ff9f25b9281a308f94068be
FilePath: src/protocol/jdbc/org/apache/jmeter/protocol/jdbc/AbstractJDBCTestElement.java**
```diff
                     }
-                    row.put(meta.getColumnName(i), o);
+                    row.put(meta.getColumnLabel(i), o);
```
ProjectName: 967-mybatis-3
CommitID: 1993f27019ac6dbe20a39819e493a78461c42103
CommitMsg: MB uses getColumnLabel by default

FilePath: src/main/java/org/apache/ibatis/logging/jdbc/ResultSetLogger.java**
```diff
       }
-      String colname = rsmd.getColumnName(i);
+      String colname = rsmd.getColumnLabel(i);
```
