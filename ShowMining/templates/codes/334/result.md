###  infomation 
method del:
-org.apache.pdfbox.pdmodel.common.PDStream.getStream()
method add：
+org.apache.pdfbox.pdmodel.common.PDStream.getCOSObject()
###  support count
project count : 1
commit count : 14
###  code
ProjectName: 22223-pdfbox
CommitID: 3ff6d106361cb560f37412aba40429e22b5fe6ef
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1727136 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/PDType1FontEmbedder.java**
```diff
         PDStream fontStream = new PDStream(doc, pfbParser.getInputStream(), COSName.FLATE_DECODE);
-        fontStream.getStream().setInt("Length", pfbParser.size());
+        fontStream.getCOSObject().setInt("Length", pfbParser.size());
```
ProjectName: 22223-pdfbox
CommitID: 3ff6d106361cb560f37412aba40429e22b5fe6ef
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1727136 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/PDType1FontEmbedder.java**
```diff
         {
-            fontStream.getStream().setInt("Length" + (i + 1), pfbParser.getLengths()[i]);
+            fontStream.getCOSObject().setInt("Length" + (i + 1), pfbParser.getLengths()[i]);
```
ProjectName: 22223-pdfbox
CommitID: 18f1e45d96a36cb643a66198375cb765e810eedb
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1727134 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/PDXObject.java**
```diff
         // could be used for writing:
-        stream.getStream().setName(COSName.TYPE, COSName.XOBJECT.getName());
-        stream.getStream().setName(COSName.SUBTYPE, subtype.getName());
+        stream.getCOSObject().setName(COSName.TYPE, COSName.XOBJECT.getName());
+        stream.getCOSObject().setName(COSName.SUBTYPE, subtype.getName());
```
ProjectName: 22223-pdfbox
CommitID: 788539c832de595d22f04bb4b2cfe268e805b41c
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726908 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/font/descriptor/CIDType0DescriptorHelper.java**
```diff
             // Stream validation should be done by the StreamValidateHelper. Process font specific check
-            COSStream stream = ff3.getStream();
+            COSStream stream = ff3.getCOSObject();
```
ProjectName: 22223-pdfbox
CommitID: 788539c832de595d22f04bb4b2cfe268e805b41c
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726908 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/font/descriptor/TrueTypeDescriptorHelper.java**
```diff
         PDStream fontFile = fontDescriptor.getFontFile2();
-        COSStream stream = (fontFile == null ? null : fontFile.getStream());
+        COSStream stream = (fontFile == null ? null : fontFile.getCOSObject());
```
ProjectName: 22223-pdfbox
CommitID: 788539c832de595d22f04bb4b2cfe268e805b41c
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726908 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/font/descriptor/Type1DescriptorHelper.java**
```diff
         {
-            COSStream stream = ff1.getStream();
+            COSStream stream = ff1.getCOSObject();
```
ProjectName: 22223-pdfbox
CommitID: 788539c832de595d22f04bb4b2cfe268e805b41c
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726908 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/font/descriptor/CIDType2DescriptorHelper.java**
```diff
             // Stream validation should be done by the StreamValidateHelper. Process font specific check
-            COSStream stream = ff2.getStream();
+            COSStream stream = ff2.getCOSObject();
```
ProjectName: 22223-pdfbox
CommitID: ba18ae205f0772655e0be160eb74b63126643f2a
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726892 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/PDType1Font.java**
```diff
                 {
-                    COSStream stream = fontFile.getStream();
+                    COSStream stream = fontFile.getCOSObject();
```
ProjectName: 22223-pdfbox
CommitID: 1178b372bd2803f78dd6f51b942fec683b1b6e01
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726891 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/PDCIDFontType2Embedder.java**
```diff
         PDStream stream = new PDStream(document, input, COSName.FLATE_DECODE);
-        stream.getStream().setInt(COSName.LENGTH1, stream.toByteArray().length);
+        stream.getCOSObject().setInt(COSName.LENGTH1, stream.toByteArray().length);
```
ProjectName: 22223-pdfbox
CommitID: 60dfcb24ab867861ed4357d5fb0d96c0c442f61f
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726887 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/color/PDOutputIntent.java**
```diff
         PDStream stream = new PDStream(doc, new ByteArrayInputStream(icc.getData()), COSName.FLATE_DECODE);
-        stream.getStream().setInt(COSName.N, icc.getNumComponents());
+        stream.getCOSObject().setInt(COSName.N, icc.getNumComponents());
```
ProjectName: 22223-pdfbox
CommitID: 7b7bc29f0ce8cf1f7d41bd7126265ac257b0d3d4
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726884 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/TrueTypeEmbedder.java**
```diff
         PDStream stream = new PDStream(document, ttfStream, COSName.FLATE_DECODE);
-        stream.getStream().setInt(COSName.LENGTH1, stream.toByteArray().length);
+        stream.getCOSObject().setInt(COSName.LENGTH1, stream.toByteArray().length);
```
ProjectName: 22223-pdfbox
CommitID: 7d90a5b5213148092ba68ffe25fb480d7e09bdb5
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726875 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/common/function/PDFunction.java**
```diff
             functionStream = new PDStream( (COSStream)function );
-            functionStream.getStream().setItem( COSName.TYPE, COSName.FUNCTION );
+            functionStream.getCOSObject().setItem( COSName.TYPE, COSName.FUNCTION );
```
ProjectName: 22223-pdfbox
CommitID: 7d90a5b5213148092ba68ffe25fb480d7e09bdb5
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726875 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/common/function/PDFunction.java**
```diff
         {
-            return functionStream.getStream();
+            return functionStream.getCOSObject();
```
ProjectName: 22223-pdfbox
CommitID: a9aa94ad181e498a464278c8cd2e20206c70b2df
CommitMsg: PDFBOX-2852: replace deprecated calls

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1726868 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/multipdf/PDFMergerUtility.java**
```diff
             PDStream newStream = new PDStream(destination, srcMetadata.createInputStream(), (COSName) null);
-            newStream.getStream().mergeInto(srcMetadata);
+            newStream.getCOSObject().mergeInto(srcMetadata);
```
