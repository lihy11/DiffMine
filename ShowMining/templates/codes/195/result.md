###  infomation 
method del:
-com.jgoodies.forms.layout.CellConstraints.xyw()
method add：
+com.jgoodies.forms.layout.CellConstraints.xy()
###  support count
project count : 1
commit count : 11
###  code
ProjectName: 23045-UniversalMediaServer
CommitID: 91e2ff91492f6ff7a2d900d99d0dacb13e7fb9c3
CommitMsg: Added tooltip to "Hide empty folders"

FilePath: src/main/java/net/pms/newgui/NavigationShareTab.java**
```diff
 			builder.add(hideengines, FormLayoutUtil.flip(cc.xyw(4, 17, 3), colSpec, orientation));
-			builder.add(hideemptyfolders, FormLayoutUtil.flip(cc.xyw(9, 17, 2), colSpec, orientation));
+			builder.add(hideemptyfolders, FormLayoutUtil.flip(cc.xy(9, 17), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: f533a54d6be3384956d52048c1f40871404f8b4a
CommitMsg: Made sure tooltips appear only when the mouse is over the text (2)

FilePath: src/main/java/net/pms/newgui/NavigationShareTab.java**
```diff
 			builder.add(sortmethod, FormLayoutUtil.flip(cc.xyw(4, 11, 3), colSpec, orientation));
-			builder.add(ignorethewordthe, FormLayoutUtil.flip(cc.xyw(9, 11, 2), colSpec, orientation));
+			builder.add(ignorethewordthe, FormLayoutUtil.flip(cc.xy(9, 11), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: f533a54d6be3384956d52048c1f40871404f8b4a
CommitMsg: Made sure tooltips appear only when the mouse is over the text (2)

FilePath: src/main/java/net/pms/newgui/NavigationShareTab.java**
```diff
 
-			builder.add(itunes, FormLayoutUtil.flip(cc.xyw(1, 19, 3), colSpec, orientation));
+			builder.add(itunes, FormLayoutUtil.flip(cc.xy(1, 19), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: 01f8ed2cf1ae80cb3132431bef661fb9539e152d
CommitMsg: Made sure tooltips appear only when the mouse is over the text

FilePath: src/main/java/net/pms/newgui/TranscodingTab.java**
```diff
 		});
-		builder.add(mpeg2remux, FormLayoutUtil.flip(cc.xyw(1, 6, 3), colSpec, orientation));
+		builder.add(mpeg2remux, FormLayoutUtil.flip(cc.xy(1, 6), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: 01f8ed2cf1ae80cb3132431bef661fb9539e152d
CommitMsg: Made sure tooltips appear only when the mouse is over the text

FilePath: src/main/java/net/pms/newgui/TranscodingTab.java**
```diff
 		});
-		builder.add(ac3remux, FormLayoutUtil.flip(cc.xyw(1, 6, 3), colSpec, orientation));
+		builder.add(ac3remux, FormLayoutUtil.flip(cc.xy(1, 6), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: 01f8ed2cf1ae80cb3132431bef661fb9539e152d
CommitMsg: Made sure tooltips appear only when the mouse is over the text

FilePath: src/main/java/net/pms/newgui/TranscodingTab.java**
```diff
 		});
-		builder.add(forceDTSinPCM, FormLayoutUtil.flip(cc.xyw(1, 8, 3), colSpec, orientation));
+		builder.add(forceDTSinPCM, FormLayoutUtil.flip(cc.xy(1, 8), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: 5209ab74516e91929d4046d3d1a54a2cd4674105
CommitMsg: Prevent text overlap in basic mode with some languages

FilePath: src/main/java/net/pms/newgui/GeneralTab.java**
```diff
 
-		builder.add(smcheckBox, FormLayoutUtil.flip(cc.xyw(1, 9, 2), colSpec, orientation));
+		builder.add(smcheckBox, FormLayoutUtil.flip(cc.xy(1, 9), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: 974cef6f47b395fd461c942784e4ba8e3caae807
CommitMsg: Made input widths consistent

FilePath: src/main/java/net/pms/encoders/MEncoderVideo.java**
```diff
 		});
-		builder.add(ocw, FormLayoutUtil.flip(cc.xyw(3, 15, 2), colSpec, orientation));
+		builder.add(ocw, FormLayoutUtil.flip(cc.xy(3, 15), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: 974cef6f47b395fd461c942784e4ba8e3caae807
CommitMsg: Made input widths consistent

FilePath: src/main/java/net/pms/encoders/MEncoderVideo.java**
```diff
 		});
-		builder.add(och, FormLayoutUtil.flip(cc.xyw(7, 15, 1), colSpec, orientation));
+		builder.add(och, FormLayoutUtil.flip(cc.xy(7, 15), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: 9dac77d743d3125ca87b4c71e612104ec49ea2c9
CommitMsg: Let button size itself

FilePath: src/main/java/net/pms/encoders/MEncoderVideo.java**
```diff
 		});
-		builder.add(button, FormLayoutUtil.flip(cc.xyw(1, 11, 2), colSpec, orientation));
+		builder.add(button, FormLayoutUtil.flip(cc.xy(1, 11), colSpec, orientation));
```
ProjectName: 23045-UniversalMediaServer
CommitID: ac03817569d8cbb260b78c79402655525b003a0c
CommitMsg: Stop labels overlapping text input boxes

FilePath: src/main/java/net/pms/encoders/MEncoderVideo.java**
```diff
 
-		builder.addLabel(Messages.getString("MEncoderVideo.7"), FormLayoutUtil.flip(cc.xyw(1, 19, 15), colSpec, orientation));
+		builder.addLabel(Messages.getString("MEncoderVideo.7"), FormLayoutUtil.flip(cc.xy(1, 19), colSpec, orientation));
```
