###  infomation 
method del:
-null.getWithCol()
method add：
+null.get()
###  support count
project count : 1
commit count : 13
###  code
ProjectName: 6935-bisq
CommitID: 5319eb39ef35370a2afbb23aa375b09e3e1f3ab2
CommitMsg: Remove unnecessary colons

FilePath: desktop/src/main/java/bisq/desktop/main/account/content/notifications/MobileNotificationsView.java**
```diff
         currencyComboBox = FormBuilder.addComboBox(root, gridRow,
-                Res.getWithCol("list.currency.select"), 40);
+                Res.get("list.currency.select"), 40);
```
ProjectName: 6935-bisq
CommitID: 5319eb39ef35370a2afbb23aa375b09e3e1f3ab2
CommitMsg: Remove unnecessary colons

FilePath: desktop/src/main/java/bisq/desktop/main/account/content/notifications/MobileNotificationsView.java**
```diff
         priceAlertHighInputTextField = addInputTextField(root, ++gridRow,
-                Res.getWithCol("account.notifications.priceAlert.high.label"));
+                Res.get("account.notifications.priceAlert.high.label"));
```
ProjectName: 6935-bisq
CommitID: 5319eb39ef35370a2afbb23aa375b09e3e1f3ab2
CommitMsg: Remove unnecessary colons

FilePath: desktop/src/main/java/bisq/desktop/main/account/content/notifications/MobileNotificationsView.java**
```diff
         priceAlertLowInputTextField = addInputTextField(root, ++gridRow,
-                Res.getWithCol("account.notifications.priceAlert.low.label"));
+                Res.get("account.notifications.priceAlert.low.label"));
```
ProjectName: 6935-bisq
CommitID: 0c2f582862a82840379233de168aa7e4621faed6
CommitMsg: Merge pull request #1625 from ripcurlx/fix-double-colon-usage

Fix double colon usage
FilePath: src/main/java/bisq/desktop/components/paymentmethods/SepaForm.java**
```diff
         FormBuilder.addLabelTextFieldWithCopyIcon(gridPane, ++gridRow,
-                Res.getWithCol("payment.bank.country"),
+                Res.get("payment.bank.country"),
```
ProjectName: 6935-bisq
CommitID: 0c2f582862a82840379233de168aa7e4621faed6
CommitMsg: Merge pull request #1625 from ripcurlx/fix-double-colon-usage

Fix double colon usage
FilePath: src/main/java/bisq/desktop/components/paymentmethods/SepaForm.java**
```diff
 
-        FormBuilder.addLabel(gridPane, ++gridRow, Res.getWithCol("payment.bank.country"));
+        FormBuilder.addLabel(gridPane, ++gridRow, Res.get("payment.bank.country"));
```
ProjectName: 6935-bisq
CommitID: 0c2f582862a82840379233de168aa7e4621faed6
CommitMsg: Merge pull request #1625 from ripcurlx/fix-double-colon-usage

Fix double colon usage
FilePath: src/main/java/bisq/desktop/components/paymentmethods/MoneyGramForm.java**
```diff
         FormBuilder.addLabelTextFieldWithCopyIcon(gridPane, ++gridRow,
-                Res.getWithCol("payment.bank.country"),
+                Res.get("payment.bank.country"),
```
ProjectName: 6935-bisq
CommitID: 0c2f582862a82840379233de168aa7e4621faed6
CommitMsg: Merge pull request #1625 from ripcurlx/fix-double-colon-usage

Fix double colon usage
FilePath: src/main/java/bisq/desktop/components/paymentmethods/SepaInstantForm.java**
```diff
         FormBuilder.addLabelTextFieldWithCopyIcon(gridPane, ++gridRow,
-                Res.getWithCol("payment.bank.country"),
+                Res.get("payment.bank.country"),
```
ProjectName: 6935-bisq
CommitID: 0c2f582862a82840379233de168aa7e4621faed6
CommitMsg: Merge pull request #1625 from ripcurlx/fix-double-colon-usage

Fix double colon usage
FilePath: src/main/java/bisq/desktop/components/paymentmethods/SepaInstantForm.java**
```diff
 
-        FormBuilder.addLabel(gridPane, ++gridRow, Res.getWithCol("payment.bank.country"));
+        FormBuilder.addLabel(gridPane, ++gridRow, Res.get("payment.bank.country"));
```
ProjectName: 6935-bisq
CommitID: a85f8de5a883ed17da15b16060e34da6d529fdb4
CommitMsg: Fix double colon usage

FilePath: src/main/java/bisq/desktop/components/paymentmethods/SepaInstantForm.java**
```diff
         FormBuilder.addLabelTextFieldWithCopyIcon(gridPane, ++gridRow,
-                Res.getWithCol("payment.bank.country"),
+                Res.get("payment.bank.country"),
```
ProjectName: 6935-bisq
CommitID: a85f8de5a883ed17da15b16060e34da6d529fdb4
CommitMsg: Fix double colon usage

FilePath: src/main/java/bisq/desktop/components/paymentmethods/SepaInstantForm.java**
```diff
 
-        FormBuilder.addLabel(gridPane, ++gridRow, Res.getWithCol("payment.bank.country"));
+        FormBuilder.addLabel(gridPane, ++gridRow, Res.get("payment.bank.country"));
```
ProjectName: 6935-bisq
CommitID: a85f8de5a883ed17da15b16060e34da6d529fdb4
CommitMsg: Fix double colon usage

FilePath: src/main/java/bisq/desktop/components/paymentmethods/MoneyGramForm.java**
```diff
         FormBuilder.addLabelTextFieldWithCopyIcon(gridPane, ++gridRow,
-                Res.getWithCol("payment.bank.country"),
+                Res.get("payment.bank.country"),
```
ProjectName: 6935-bisq
CommitID: a85f8de5a883ed17da15b16060e34da6d529fdb4
CommitMsg: Fix double colon usage

FilePath: src/main/java/bisq/desktop/components/paymentmethods/SepaForm.java**
```diff
         FormBuilder.addLabelTextFieldWithCopyIcon(gridPane, ++gridRow,
-                Res.getWithCol("payment.bank.country"),
+                Res.get("payment.bank.country"),
```
ProjectName: 6935-bisq
CommitID: a85f8de5a883ed17da15b16060e34da6d529fdb4
CommitMsg: Fix double colon usage

FilePath: src/main/java/bisq/desktop/components/paymentmethods/SepaForm.java**
```diff
 
-        FormBuilder.addLabel(gridPane, ++gridRow, Res.getWithCol("payment.bank.country"));
+        FormBuilder.addLabel(gridPane, ++gridRow, Res.get("payment.bank.country"));
```
