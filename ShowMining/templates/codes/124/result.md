###  infomation 
method del:
-null.createPopup()
method add：
+null.getRelatedItemsPopup()
###  support count
project count : 1
commit count : 11
###  code
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: 3ae5706682ecd9e13bca8e6a099124a9fa7738b8
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: ac9a339395c74c1a46875dd0028eba521441c3d6
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: bac43ab7456b07c17c1c2f8a5552ed1fd4d0562f
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: c5f48f4b915b66caf5e46685522f3aca072f61c5
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: 4bf73bb62658f90be58d2fa09eae2116092986b8
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: 80209088a8aba7bdaae97a849eaef6e5028e74db
CommitMsg: Merge branch 'master' into feature/phpstorm-8

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: c606a06250d53445bacbd4a21c8fe1edc3ebc3f2
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: fa22133aa694d8a84b99a7cae7c787a038e270fa
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: 63ef6bad390f7bb6d77f2cdc3f766f4277b11385
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: 126d51da727cde1735f196e2a41e5bd8583b00ad
CommitMsg: Merge branch 'master' into feature/phpstorm-8

Conflicts:
	META-INF/plugin.xml

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedFileAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
ProjectName: 29307-idea-php-symfony2-plugin
CommitID: deba4ce8ac34d168c21c46192acc7c880981f00d
CommitMsg: use NavigationUtil for popups to fix eap api changes #329

FilePath: src/fr/adrienbrault/idea/symfony2plugin/dic/RelatedPopupGotoLineMarker.java**
```diff
             } else {
-                GotoRelatedSymbolAction.createPopup(items, "Go to Related Files").show(new RelativePoint(e));
+                NavigationUtil.getRelatedItemsPopup(items, "Go to Related Files").show(new RelativePoint(e));
```
