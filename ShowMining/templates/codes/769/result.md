###  infomation 
method del:
-java.util.List.add()
method add：
+java.util.Collections.addAll()
###  support count
project count : 9
commit count : 12
###  code
ProjectName: 21551-struts
CommitID: 659a688d25477a9c9a8a8487b1948520e6cec17b
CommitMsg: Improves adding tokens to collection

git-svn-id: https://svn.apache.org/repos/asf/struts/struts2/trunk@1215224 13f79535-47bb-0310-9956-ffa450edef68

FilePath: core/src/main/java/org/apache/struts2/dispatcher/mapper/DefaultActionMapper.java**
```diff
             String[] tokens = extensions.split(",");
-            for (String token : tokens) {
-                list.add(token);
-            }
+            Collections.addAll(list, tokens);
```
ProjectName: 28966-ringojs
CommitID: 95c8401155a7ebe7e226b2c343f4d516c7bd532a
CommitMsg: Split -m/--modules command line arguments using path.seprarator

Closes #183

FilePath: src/org/ringojs/tools/RingoRunner.java**
```diff
         } else if ("modules".equals(option)) {
-            userModules.add(arg);
+            Collections.addAll(userModules,
+                    StringUtils.split(arg, File.pathSeparator));
```
ProjectName: 10166-Anki-Android
CommitID: d6ab2c8f09f98d25b21bf7550438cdda0d7be6c1
CommitMsg: Manual array to collection copy replaced with addAll.

FilePath: src/com/ichi2/themes/StyledDialog.java**
```diff
         mItemList = new ArrayList<String>();
-        for (String titel : values) {
-            mItemList.add(titel);
-        }
+        Collections.addAll(mItemList, values);
```
ProjectName: 13180-assertj-core
CommitID: 6acfc42dd22221130c11ff5a6692ffb542554668
CommitMsg: Use Collections to copy elements

FilePath: src/main/java/org/assertj/core/api/filter/Filters.java**
```diff
     List<E> iterable = new ArrayList<E>(array.length);
-    for (E anArray : array) {
-      iterable.add(anArray);
-    }
+    Collections.addAll(iterable, array);
```
ProjectName: 13180-assertj-core
CommitID: 6acfc42dd22221130c11ff5a6692ffb542554668
CommitMsg: Use Collections to copy elements

FilePath: src/main/java/org/assertj/core/groups/Tuple.java**
```diff
   public Tuple(Object... values) {
-    for (Object value : values) {
-      datas.add(value);
-    }
+    java.util.Collections.addAll(datas, values);
```
ProjectName: 15151-jabref
CommitID: 55962e1c0b3d361cd427a948f85270adf996384f
CommitMsg: Use Collections.addAll instead of adding the values manually.

FilePath: src/main/java/net/sf/jabref/openoffice/AutoDetectPaths.java**
```diff
             });
-            for (File dir : dirs) {
-                dirList.add(dir);
-            }
+            Collections.addAll(dirList, dirs);
```
ProjectName: 5737-junit5
CommitID: 9fb60682e4d42f37cbd3f833d59487ac1c538d24
CommitMsg: Apply IntelliJ-suggested code changes

`ToStringBuilder.java` was unnecessarily creating both a
`StringBuilder` and a `Stream` within `toString()`, where regular
string concatenation and `String.join()` would have been equally
performant and probably more readable.

`XmlReportWriter.java` was also creating a `StringBuilder` where
regular string concatenation would have worked just as well. Whether
it is more readable though is up for debate.

`TestExecutionListenerRegistry.java` was adding things to a collection
via manual looping, where calling `Collections.addAll` would have been
shorter and probably more readable.

FilePath: junit-platform-launcher/src/main/java/org/junit/platform/launcher/core/TestExecutionListenerRegistry.java**
```diff
 	void registerListeners(TestExecutionListener... listeners) {
-		for (TestExecutionListener listener : listeners) {
-			this.testExecutionListeners.add(listener);
-		}
+		Collections.addAll(this.testExecutionListeners, listeners);
```
ProjectName: 4073-Android-Iconics
CommitID: 23ecbe9377b58dd98584e8b9d8beacbb77bc0377
CommitMsg: * improve Iconics class (fix lint warning :D)

FilePath: library/src/main/java/com/mikpenz/iconics/Iconics.java**
```diff
             if (styles != null && styles.length > 0) {
-                for (CharacterStyle style : styles) {
-                    this.styles.add(style);
-                }
+                Collections.addAll(this.styles, styles);
```
ProjectName: 16323-WorldEdit
CommitID: eba1114b39735cd5548d68af1daae51807d78d81
CommitMsg: IntelliJ demanded attention.

FilePath: src/main/java/com/sk89q/worldedit/expression/runtime/Switch.java**
```diff
                 if (invokable instanceof Sequence) {
-                    for (RValue subInvokable : ((Sequence) invokable).sequence) {
-                        newSequence.add(subInvokable);
-                    }
+                    Collections.addAll(newSequence, ((Sequence) invokable).sequence);
```
ProjectName: 967-mybatis-3
CommitID: e0ae4ad0e89dd1a004cd29f409da575c95962a14
CommitMsg: Merge pull request #1672 from donhui/0920-2

promote 1000 to long
FilePath: src/main/java/org/apache/ibatis/jdbc/AbstractSQL.java**
```diff
     List<String> list = sql().valuesList.get(sql().valuesList.size() - 1);
-    for (String value : values) {
-      list.add(value);
-    }
+    Collections.addAll(list, values);
```
ProjectName: 967-mybatis-3
CommitID: 2be51e1ea7052fad361b4493d01f1f3014bd05ed
CommitMsg: Merge pull request #1674 from xdshent/dev

refactor: simplify three lines code in AbstractSQL.java
FilePath: src/main/java/org/apache/ibatis/jdbc/AbstractSQL.java**
```diff
     List<String> list = sql().valuesList.get(sql().valuesList.size() - 1);
-    for (String value : values) {
-      list.add(value);
-    }
+    Collections.addAll(list, values);
```
ProjectName: 967-mybatis-3
CommitID: bebe29f7ef551f1b4576240f11cbfa47f2e8779f
CommitMsg: refactor: simplify three lines code in AbstractSQL.java

replace `foreach statement` with `Collections.addAll`

FilePath: src/main/java/org/apache/ibatis/jdbc/AbstractSQL.java**
```diff
     List<String> list = sql().valuesList.get(sql().valuesList.size() - 1);
-    for (String value : values) {
-      list.add(value);
-    }
+    Collections.addAll(list, values);
```
