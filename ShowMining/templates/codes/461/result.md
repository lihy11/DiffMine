###  infomation 
method del:
-null.equal()
method add：
+java.util.Objects.equals()
###  support count
project count : 6
commit count : 10
###  code
ProjectName: 37503-sonar-java
CommitID: ba1bca8124e040afe07fc6c8f2feed4d059deb9a
CommitMsg: Use java.util.Objects instead of deprecated Guava alternatives

FilePath: java-frontend/src/main/java/org/sonar/java/se/Flow.java**
```diff
     Flow other = (Flow) obj;
-    return Objects.equal(elements, other.elements)
+    return Objects.equals(elements, other.elements)
```
ProjectName: 37503-sonar-java
CommitID: ba1bca8124e040afe07fc6c8f2feed4d059deb9a
CommitMsg: Use java.util.Objects instead of deprecated Guava alternatives

FilePath: java-frontend/src/main/java/org/sonar/java/model/SyntacticEquivalence.java**
```diff
     if (leftNode instanceof SyntaxToken) {
-      return Objects.equal(((SyntaxToken) leftNode).text(), ((SyntaxToken) rightNode).text());
+      return Objects.equals(((SyntaxToken) leftNode).text(), ((SyntaxToken) rightNode).text());
```
ProjectName: 15151-jabref
CommitID: 7bd97ef778bec92d222ffc06bb5ceea843d3a778
CommitMsg: Merge pull request #1202 from oscargus/correctcharset

Replaced some Guava usage with standard java.*
FilePath: src/main/java/net/sf/jabref/logic/journals/Abbreviation.java**
```diff
             Abbreviation that = (Abbreviation) o;
-            return Objects.equal(name, that.name);
+            return Objects.equals(name, that.name);
```
ProjectName: 15151-jabref
CommitID: b5f518583f3315abc1ac02dd10fe2612715af10c
CommitMsg: Replaced some Guava usage with standard java.*

FilePath: src/main/java/net/sf/jabref/logic/journals/Abbreviation.java**
```diff
             Abbreviation that = (Abbreviation) o;
-            return Objects.equal(name, that.name);
+            return Objects.equals(name, that.name);
```
ProjectName: 2016-dropwizard
CommitID: e441709c26800c3aaa41e0e5af308924ede2c1d5
CommitMsg: Replace Guava Objects with JDK Objects

FilePath: dropwizard-servlets/src/main/java/io/dropwizard/servlets/assets/ByteRange.java**
```diff
         final ByteRange other = (ByteRange) obj;
-        return Objects.equal(start, other.start) && Objects.equal(end, other.end);
+        return Objects.equals(start, other.start) && Objects.equals(end, other.end);
```
ProjectName: 3683-checkstyle
CommitID: 02ae6023b5b6f66e495393a6f87e4beb4b4ab3d0
CommitMsg: replace deprecated method in HiddenCheckField
FilePath: src/main/java/com/puppycrawl/tools/checkstyle/checks/coding/HiddenFieldCheck.java**
```diff
             while (currentFrame != null) {
-                if (Objects.equal(currentFrame.frameName, classOrEnumName)) {
+                if (java.util.Objects.equals(currentFrame.frameName, classOrEnumName)) {
```
ProjectName: 8346-pmd
CommitID: 2f4d852017ae70af327b520f04bfae218ddfd12f
CommitMsg: Use the right import

FilePath: pmd-core/src/main/java/net/sourceforge/pmd/benchmark/TimeTracker.java**
```diff
             }
-            return Objects.equal(label, other.label);
+            return Objects.equals(label, other.label);
```
ProjectName: 38627-presto
CommitID: 588613a0e7065732b9496c42ff6f69db49ea7594
CommitMsg: Replace Guava hashCode() and equal() with hash() and equals()

FilePath: presto-main/src/main/java/com/facebook/presto/memory/MemoryPoolId.java**
```diff
         MemoryPoolId that = (MemoryPoolId) o;
-        return Objects.equal(id, that.id);
+        return Objects.equals(id, that.id);
```
ProjectName: 38627-presto
CommitID: 588613a0e7065732b9496c42ff6f69db49ea7594
CommitMsg: Replace Guava hashCode() and equal() with hash() and equals()

FilePath: presto-main/src/main/java/com/facebook/presto/memory/ClusterMemoryPool.java**
```diff
         ClusterMemoryPool that = (ClusterMemoryPool) o;
-        return Objects.equal(id, that.id);
+        return Objects.equals(id, that.id);
```
ProjectName: 38627-presto
CommitID: 588613a0e7065732b9496c42ff6f69db49ea7594
CommitMsg: Replace Guava hashCode() and equal() with hash() and equals()

FilePath: presto-example-http/src/main/java/com/facebook/presto/example/ExampleTableLayoutHandle.java**
```diff
         ExampleTableLayoutHandle that = (ExampleTableLayoutHandle) o;
-        return Objects.equal(table, that.table);
+        return Objects.equals(table, that.table);
```
