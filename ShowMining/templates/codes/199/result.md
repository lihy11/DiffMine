###  infomation 
method del:
-org.apache.pdfbox.cos.COSArray.get()
method add：
+org.apache.pdfbox.cos.COSArray.getObject()
###  support count
project count : 1
commit count : 12
###  code
ProjectName: 22223-pdfbox
CommitID: 6609b8f14b8cf82f1772e850897ab4ccc299560a
CommitMsg: PDFBOX-3847: accept object references

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1800444 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/rendering/PageDrawer.java**
```diff
         {
-            if (border.get(2) instanceof COSNumber)
+            if (border.getObject(2) instanceof COSNumber)
```
ProjectName: 22223-pdfbox
CommitID: b203362f2d12e55c59146aca11a5d4136b784c1d
CommitMsg: PDFBOX-2852: dereference if needed

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1791826 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/blend/BlendMode.java**
```diff
             {
-                result = BLEND_MODES.get(cosBlendModeArray.get(i));
+                result = BLEND_MODES.get(cosBlendModeArray.getObject(i));
```
ProjectName: 22223-pdfbox
CommitID: 1514204a2c11cfd71be8b78f818f5cb36845b23b
CommitMsg: PDFBOX-3609: allow object reference

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1772091 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/PDCIDFont.java**
```diff
                     {
-                        COSNumber width = (COSNumber) array.get(i);
+                        COSNumber width = (COSNumber) array.getObject(i);
```
ProjectName: 22223-pdfbox
CommitID: d6500dbc30019ff51cbb53fb4dc7585420049a07
CommitMsg: PDFBOX-3097: use getObject instead of get + minor code cleanup

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1713694 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/shading/RadialShadingContext.java**
```diff
             extend = new boolean[2];
-            extend[0] = ((COSBoolean) extendValues.get(0)).getValue();
-            extend[1] = ((COSBoolean) extendValues.get(1)).getValue();
+            extend[0] = ((COSBoolean) extendValues.getObject(0)).getValue();
+            extend[1] = ((COSBoolean) extendValues.getObject(1)).getValue();
```
ProjectName: 22223-pdfbox
CommitID: d6500dbc30019ff51cbb53fb4dc7585420049a07
CommitMsg: PDFBOX-3097: use getObject instead of get + minor code cleanup

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1713694 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/shading/AxialShadingContext.java**
```diff
             extend = new boolean[2];
-            extend[0] = ((COSBoolean) extendValues.get(0)).getValue();
-            extend[1] = ((COSBoolean) extendValues.get(1)).getValue();
+            extend[0] = ((COSBoolean) extendValues.getObject(0)).getValue();
+            extend[1] = ((COSBoolean) extendValues.getObject(1)).getValue();
```
ProjectName: 22223-pdfbox
CommitID: b9fa756ac73d6018461f0929d0c9d2c6efadab66
CommitMsg: PDFBOX-2959: array elements can be indirect

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1701435 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/common/COSArrayList.java**
```diff
             {
-                numbers.add( ((COSNumber)floatArray.get( i )).floatValue());
+                numbers.add(((COSNumber) floatArray.getObject(i)).floatValue());
```
ProjectName: 22223-pdfbox
CommitID: b640ee0bdb8e47d1f40015eb4b5791a73c34840b
CommitMsg: PDFBOX-2960: pattern name can be an indirect object; fix javadoc

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1701418 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/color/PDColorSpace.java**
```diff
             COSArray array = (COSArray)colorSpace;
-            COSName name = (COSName)array.get(0);
+            COSName name = (COSName)array.getObject(0);
```
ProjectName: 22223-pdfbox
CommitID: 82dde646ebb3a2f9cfa9f1f159b4360a5598597f
CommitMsg: PDFBOX-2935: /Font array member 0 is an indirect object in ExtGState dict

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1695927 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/PDFontSetting.java**
```diff
         PDFont retval = null;
-        COSBase font = fontSetting.get( 0 );
+        COSBase font = fontSetting.getObject(0);
```
ProjectName: 22223-pdfbox
CommitID: 1db64ec676171bd006e0fb146e6946ca560c3d49
CommitMsg: PDFBOX-2459: dereference kid to avoid empty list return if kids are indirect

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1679518 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/interactive/form/PDTerminalField.java**
```diff
             {
-                COSBase kid = kids.get(i);
+                COSBase kid = kids.getObject(i);
```
ProjectName: 22223-pdfbox
CommitID: ed2a718d590669712a4b0bd8fc5b95bd579efb00
CommitMsg: PDFBOX-2459: avoid ClassCastException

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1679509 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/interactive/form/PDNonTerminalField.java**
```diff
         {
-            PDField field = PDField.fromDictionary(acroForm, (COSDictionary)kids.get(i), this);
+            PDField field = PDField.fromDictionary(acroForm, (COSDictionary)kids.getObject(i), this);
```
ProjectName: 22223-pdfbox
CommitID: 47a0366d92c0f5f876c0e4f976af38461870cdac
CommitMsg: PDFBOX-1475: fixed handling of decode params if those are provided as COSArray

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1425921 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/filter/CCITTFaxDecodeFilter.java**
```diff
         {
-            decodeParms =  (COSDictionary)((COSArray)decodeP).get(filterIndex);
+            decodeParms =  (COSDictionary)((COSArray)decodeP).getObject(filterIndex);
```
ProjectName: 22223-pdfbox
CommitID: 47a0366d92c0f5f876c0e4f976af38461870cdac
CommitMsg: PDFBOX-1475: fixed handling of decode params if those are provided as COSArray

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1425921 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/xobject/PDCcitt.java**
```diff
             }
-            decodeParms =  (COSDictionary)((COSArray)decodeP).get(index);
+            decodeParms =  (COSDictionary)((COSArray)decodeP).getObject(index);
```
