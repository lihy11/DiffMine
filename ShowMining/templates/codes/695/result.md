###  infomation 
method del:
-java.lang.System.arraycopy()
method add：
+java.util.Arrays.copyOf()
###  support count
project count : 6
commit count : 11
###  code
ProjectName: 20744-codelibrary
CommitID: 114b705b5ab018908fe222168a3b6f9d650d6c76
CommitMsg: update

FilePath: java/src/ConvexHull.java**
```diff
 				;
-		Point[] res = new Point[cnt - 1 - (q[0].compareTo(q[1]) == 0 ? 1 : 0)];
-		System.arraycopy(q, 0, res, 0, res.length);
-		return res;
+		return Arrays.copyOf(q, cnt - 1 - (q[0].compareTo(q[1]) == 0 ? 1 : 0));
```
ProjectName: 20744-codelibrary
CommitID: 7aa7749da449b8cfdf5951fba026a74a3e3ce3d7
CommitMsg: update

FilePath: java/src/PolygonAlgo.java**
```diff
 				;
-		Point[] res = new Point[k - 1 - (q[0].compareTo(q[1]) == 0 ? 1 : 0)];
-		System.arraycopy(q, 0, res, 0, res.length);
-		return res;
+		return Arrays.copyOf(q, k - 1 - (q[0].compareTo(q[1]) == 0 ? 1 : 0));
```
ProjectName: 2574-antlr4
CommitID: 1906e4a639c118ff325d0b88974cb76cb83a9707
CommitMsg: Use IntervalSet.or and Arrays.copyOf instead of duplicating their functionality

FilePath: tool/src/org/antlr/v4/codegen/model/LL1StarBlock.java**
```diff
 		IntervalSet lastLook = altLookSets[altLookSets.length-1];
-		IntervalSet[] copy = new IntervalSet[altLookSets.length-1];
-		System.arraycopy(altLookSets, 0, copy, 0, altLookSets.length-1); // remove last (exit) alt
-		altLookSets = copy;
+		// remove last (exit) alt
+		altLookSets = Arrays.copyOf(altLookSets, altLookSets.length - 1);
```
ProjectName: 2574-antlr4
CommitID: b7e5cbd7f586936e255605f7c7da58e0d3950354
CommitMsg: Use Arrays.copyOf

FilePath: runtime/Java/src/org/antlr/v4/runtime/ANTLRInputStream.java**
```diff
    					// System.out.println("### overflow p="+p+", data.length="+data.length);
-   					char[] newdata = new char[data.length*2]; // resize
-   					System.arraycopy(data, 0, newdata, 0, data.length);
-   					data = newdata;
+   					data = Arrays.copyOf(data, data.length * 2);
```
ProjectName: 2574-antlr4
CommitID: b7e5cbd7f586936e255605f7c7da58e0d3950354
CommitMsg: Use Arrays.copyOf

FilePath: runtime/Java/src/org/antlr/v4/runtime/UnbufferedTokenStream.java**
```diff
 		if ( n>=tokens.length ) {
-			Token[] newtokens = new Token[tokens.length*2]; // resize
-			System.arraycopy(tokens, 0, newtokens, 0, tokens.length);
-			tokens = newtokens;
+			tokens = Arrays.copyOf(tokens, tokens.length * 2);
```
ProjectName: 2574-antlr4
CommitID: b7e5cbd7f586936e255605f7c7da58e0d3950354
CommitMsg: Use Arrays.copyOf

FilePath: runtime/Java/src/org/antlr/v4/runtime/UnbufferedCharStream.java**
```diff
 		if ( n>=data.length ) {
-			char[] newdata = new char[data.length*2]; // resize
-            System.arraycopy(data, 0, newdata, 0, data.length);
-            data = newdata;
+			data = Arrays.copyOf(data, data.length * 2);
```
ProjectName: 7606-opengrok
CommitID: 9b629d17ac5c266cc092ad6ad21a3088f7f07650
CommitMsg: Simplified buffer expansion in PlainAnalyzer

FilePath: src/org/opensolaris/opengrok/analysis/plain/PlainAnalyzer.java**
```diff
                 if (rbytes == (content.length - len)) {
-                    char[] content2 = new char[content.length * 2];
-                    System.arraycopy(content, 0, content2, 0, content.length);
-                    content = content2;
+                    content = Arrays.copyOf(content, content.length * 2);
```
ProjectName: 10731-h2database
CommitID: bc7d3f8a0a6559714279283059965ff17daf2b02
CommitMsg: `FunctionCursorResultSet`: use `Arrays.copyOf` instead of `System.arraycopy`

FilePath: h2/src/main/org/h2/index/FunctionCursorResultSet.java**
```diff
             Value[] currentRow = result.currentRow();
-            values = new Value[columnCount];
-            System.arraycopy(currentRow, 0, values, 0, columnCount);
+            values = Arrays.copyOf(currentRow, columnCount);
```
ProjectName: 15726-avro
CommitID: ff5c4d6db9af3edd915a2176a627d51eb3478da3
CommitMsg: AVRO-2654: Use JDK Arrays.copyOf (#743)


FilePath: lang/java/avro/src/main/java/org/apache/avro/data/RecordBuilderBase.java**
```diff
     fields = schema.getFields().toArray(EMPTY_FIELDS);
-    fieldSetFlags = new boolean[other.fieldSetFlags.length];
-    System.arraycopy(other.fieldSetFlags, 0, fieldSetFlags, 0, fieldSetFlags.length);
+    fieldSetFlags = Arrays.copyOf(other.fieldSetFlags, other.fieldSetFlags.length);
```
ProjectName: 15726-avro
CommitID: 0de805575f41c2d7deff9fcbe408e51606f88269
CommitMsg: AVRO-2310: GenericData Array Add Use JDK Copy Facilities

FilePath: lang/java/avro/src/main/java/org/apache/avro/generic/GenericData.java**
```diff
       if (size == elements.length) {
-        Object[] newElements = new Object[(size * 3)/2 + 1];
-        System.arraycopy(elements, 0, newElements, 0, size);
-        elements = newElements;
+        // Increase size by 1.5x + 1
+        final int newSize = size + (size >> 1) + 1;
+        elements = Arrays.copyOf(elements, newSize);
```
ProjectName: 130-okhttp
CommitID: cdae153cd0bb80e7cf75a4656f7706719d457b7b
CommitMsg: Merge pull request #4755 from square/jakew/intrinsic/2019-03-21

Switch to Arrays.copyOf for expanding array
FilePath: okhttp/src/main/java/okhttp3/internal/Util.java**
```diff
   public static String[] concat(String[] array, String value) {
-    String[] result = new String[array.length + 1];
-    System.arraycopy(array, 0, result, 0, array.length);
+    String[] result = Arrays.copyOf(array, array.length + 1);
```
