###  infomation 
method del:
-org.apache.pdfbox.cos.COSStream.getUnfilteredStream()
method add：
+org.apache.pdfbox.cos.COSStream.createInputStream()
###  support count
project count : 1
commit count : 25
###  code
ProjectName: 22223-pdfbox
CommitID: 3872d24f681f340ccef9c4c6816c8ce2380afc7d
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702081 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/process/CatalogValidationProcess.java**
```diff
 
-            ICC_Profile iccp = ICC_Profile.getInstance(stream.getUnfilteredStream());
+            ICC_Profile iccp = ICC_Profile.getInstance(stream.createInputStream());
```
ProjectName: 22223-pdfbox
CommitID: 3872d24f681f340ccef9c4c6816c8ce2380afc7d
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702081 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/font/DescendantFontValidator.java**
```diff
                 // todo: check the map's content? (won't pdfbox do this?)
-                InputStream is = stream.getUnfilteredStream();
+                InputStream is = stream.createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: 3872d24f681f340ccef9c4c6816c8ce2380afc7d
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702081 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/font/Type0FontValidator.java**
```diff
             // extract information from the CMap stream
-            cmapStream = aCMap.getUnfilteredStream();
+            cmapStream = aCMap.createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: 3872d24f681f340ccef9c4c6816c8ce2380afc7d
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702081 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/graphic/ICCProfileWrapper.java**
```diff
                     {
-                        ICC_Profile iccp = ICC_Profile.getInstance(stream.getUnfilteredStream());
+                        ICC_Profile iccp = ICC_Profile.getInstance(stream.createInputStream());
```
ProjectName: 22223-pdfbox
CommitID: 3872d24f681f340ccef9c4c6816c8ce2380afc7d
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702081 13f79535-47bb-0310-9956-ffa450edef68

FilePath: preflight/src/main/java/org/apache/pdfbox/preflight/process/MetadataValidationProcess.java**
```diff
         COSStream stream = (COSStream) metadataDictionnary;
-        return stream.getUnfilteredStream();
+        return stream.createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: 3b1bb6afb8adb5432d3b7521f89a50cb05fc22bb
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702077 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdfparser/PDFObjectStreamParser.java**
```diff
     {
-        super(new InputStreamSource(stream.getUnfilteredStream()));
+        super(new InputStreamSource(stream.createInputStream()));
```
ProjectName: 22223-pdfbox
CommitID: 3b1bb6afb8adb5432d3b7521f89a50cb05fc22bb
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702077 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdfparser/PDFXrefStreamParser.java**
```diff
     {
-        super(new InputStreamSource(stream.getUnfilteredStream()));
+        super(new InputStreamSource(stream.createInputStream()));
```
ProjectName: 22223-pdfbox
CommitID: 3b1bb6afb8adb5432d3b7521f89a50cb05fc22bb
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702077 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdfparser/PDFStreamParser.java**
```diff
     {
-        super(new InputStreamSource(stream.getUnfilteredStream()));
+        super(new InputStreamSource(stream.createInputStream()));
```
ProjectName: 22223-pdfbox
CommitID: 3d3b4ddfb004788f59af96679a3fa6b019fd231a
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702074 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/multipdf/Overlay.java**
```diff
         {
-            InputStream in = contentStream.getUnfilteredStream();
+            InputStream in = contentStream.createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: 3d3b4ddfb004788f59af96679a3fa6b019fd231a
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702074 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/filter/JBIG2Filter.java**
```diff
                 iis = ImageIO.createImageInputStream(
-                        new SequenceInputStream(globals.getUnfilteredStream(), encoded));
+                        new SequenceInputStream(globals.createInputStream(), encoded));
```
ProjectName: 22223-pdfbox
CommitID: 5a15729a9c9457c82dc07bd7f9c6117614846da2
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702072 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/PDPage.java**
```diff
         {
-            return ((COSStream)base).getUnfilteredStream();
+            return ((COSStream)base).createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: 5a15729a9c9457c82dc07bd7f9c6117614846da2
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702072 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/PDPage.java**
```diff
                 COSStream stream = (COSStream)streams.getObject(i);
-                inputStreams.add(stream.getUnfilteredStream());
+                inputStreams.add(stream.createInputStream());
```
ProjectName: 22223-pdfbox
CommitID: deed40b19330459499ddf563ecec6e9cfe795452
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702071 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/interactive/form/PDXFAResource.java**
```diff
                     {
-                        is = ((COSStream) cosObj).getUnfilteredStream();
+                        is = ((COSStream) cosObj).createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: deed40b19330459499ddf563ecec6e9cfe795452
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702071 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/interactive/form/PDXFAResource.java**
```diff
                 xfaBytes = new byte[1024];
-                is = ((COSStream) xfa.getCOSObject()).getUnfilteredStream();
+                is = ((COSStream) xfa.getCOSObject()).createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: deed40b19330459499ddf563ecec6e9cfe795452
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702071 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/pattern/PDTilingPattern.java**
```diff
     {
-        return ((COSStream)getCOSObject()).getUnfilteredStream();
+        return ((COSStream)getCOSObject()).createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: d312fcded017733655354bbd554d02929a5c8842
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702069 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/PDFont.java**
```diff
             {
-                input = ((COSStream)base).getUnfilteredStream();
+                input = ((COSStream)base).createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: d312fcded017733655354bbd554d02929a5c8842
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702069 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/PDType3CharProc.java**
```diff
     {
-        return charStream.getUnfilteredStream();
+        return charStream.createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: d312fcded017733655354bbd554d02929a5c8842
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702069 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/PDCIDFontType2.java**
```diff
 
-            InputStream is = stream.getUnfilteredStream();
+            InputStream is = stream.createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: 248073e110da18bcbfe1f7f22d670a1865aa41fe
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702052 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/shading/Type5ShadingContext.java**
```diff
 
-        ImageInputStream mciis = new MemoryCacheImageInputStream(cosStream.getUnfilteredStream());
+        ImageInputStream mciis = new MemoryCacheImageInputStream(cosStream.createInputStream());
```
ProjectName: 22223-pdfbox
CommitID: 248073e110da18bcbfe1f7f22d670a1865aa41fe
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702052 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/shading/PatchMeshesShadingContext.java**
```diff
 
-        ImageInputStream mciis = new MemoryCacheImageInputStream(cosStream.getUnfilteredStream());
+        ImageInputStream mciis = new MemoryCacheImageInputStream(cosStream.createInputStream());
```
ProjectName: 22223-pdfbox
CommitID: 248073e110da18bcbfe1f7f22d670a1865aa41fe
CommitMsg: PDFBOX-2852: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1702052 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/shading/Type4ShadingContext.java**
```diff
 
-        ImageInputStream mciis = new MemoryCacheImageInputStream(stream.getUnfilteredStream());
+        ImageInputStream mciis = new MemoryCacheImageInputStream(stream.createInputStream());
```
ProjectName: 22223-pdfbox
CommitID: 727a861eb95d580f69f179772f6c811ab15a7400
CommitMsg: PDFBOX-2842: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1701928 13f79535-47bb-0310-9956-ffa450edef68

FilePath: tools/src/main/java/org/apache/pdfbox/tools/pdfdebugger/fontencodingpane/Type0Font.java**
```diff
 
-            InputStream is = stream.getUnfilteredStream();
+            InputStream is = stream.createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: 76b333310a9e086420c9186a8999ab2f4a28051e
CommitMsg: PDFBOX-2842: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1701926 13f79535-47bb-0310-9956-ffa450edef68

FilePath: tools/src/main/java/org/apache/pdfbox/tools/pdfdebugger/streampane/Stream.java**
```diff
             {
-                return stream.getUnfilteredStream();
+                return stream.createInputStream();
```
ProjectName: 22223-pdfbox
CommitID: 32fbe0dd14aacf32ceb1b458cb2d6dbf086fa0a7
CommitMsg: PDFBOX-2842: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1701924 13f79535-47bb-0310-9956-ffa450edef68

FilePath: tools/src/main/java/org/apache/pdfbox/tools/pdfdebugger/ui/Tree.java**
```diff
                 {
-                    byte[] bytes = IOUtils.toByteArray(cosStream.getUnfilteredStream());
+                    byte[] bytes = IOUtils.toByteArray(cosStream.createInputStream());
```
ProjectName: 22223-pdfbox
CommitID: ae8ab254fd2d144bb67c032e63749ddbf4185e93
CommitMsg: PDFBOX-2842: fix call to deprecated method

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1701922 13f79535-47bb-0310-9956-ffa450edef68

FilePath: tools/src/main/java/org/apache/pdfbox/tools/PDFDebugger.java**
```diff
                 COSStream stream = (COSStream)selectedNode;
-                InputStream ioStream = stream.getUnfilteredStream();
+                InputStream ioStream = stream.createInputStream();
```
