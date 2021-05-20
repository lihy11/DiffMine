###  infomation 
method del:
-null.commit()
method add：
+null.apply()
###  support count
project count : 6
commit count : 14
###  code
ProjectName: 20057-AnySoftKeyboard
CommitID: c88d60917960b0ac6685dfcc5ea22533234dd06a
CommitMsg: Fixing critical lint issues

FilePath: app/src/main/java/com/anysoftkeyboard/keyboards/KeyboardSwitcher.java**
```diff
         editor.putStringSet(mContext.getString(R.string.settings_key_persistent_layout_per_package_id_mapping), mapping);
-        editor.commit();
+        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
```
ProjectName: 22766-bugsnag-android
CommitID: 9718c8a70e854fe790c0bcccf3d4f4cfe948ac38
CommitMsg: Cleanup

FilePath: sdk/src/main/java/com/bugsnag/android/DeviceData.java**
```diff
             installId = UUID.randomUUID().toString();
-            sharedPref.edit().putString(INSTALL_ID_KEY, installId).commit();
+            sharedPref.edit().putString(INSTALL_ID_KEY, installId).apply();
```
ProjectName: 14745-android
CommitID: 9021848af693faf27466f97f39d7f8ffe46c3134
CommitMsg: use apply instead of commit

FilePath: src/main/java/com/owncloud/android/authentication/AccountUtils.java**
```diff
     
-                    appPrefs.commit();
+                    appPrefs.apply();
```
ProjectName: 14745-android
CommitID: 9021848af693faf27466f97f39d7f8ffe46c3134
CommitMsg: use apply instead of commit

FilePath: src/main/java/com/owncloud/android/db/PreferenceManager.java**
```diff
         appPreferences.putString(key, value);
-        appPreferences.commit();
+        appPreferences.apply();
```
ProjectName: 14745-android
CommitID: 9021848af693faf27466f97f39d7f8ffe46c3134
CommitMsg: use apply instead of commit

FilePath: src/main/java/com/owncloud/android/authentication/AuthenticatorActivity.java**
```diff
                 editor.putString("select_oc_account", accountName);
-                editor.commit();
+                editor.apply();
```
ProjectName: 14745-android
CommitID: 086e18d377a86a1c46274a5e0ac117005662d2ca
CommitMsg: use apply() instead of commit()

FilePath: src/main/java/com/owncloud/android/ui/activity/Preferences.java**
```diff
         editor.putString(PreferenceKeys.STORAGE_PATH, mStoragePath);
-        editor.commit();
+        editor.apply();
```
ProjectName: 14745-android
CommitID: 086e18d377a86a1c46274a5e0ac117005662d2ca
CommitMsg: use apply() instead of commit()

FilePath: src/main/java/com/owncloud/android/ui/activity/Preferences.java**
```diff
         editor.putString(PreferenceKeys.INSTANT_UPLOAD_PATH, mUploadPath);
-        editor.commit();
+        editor.apply();
```
ProjectName: 14745-android
CommitID: 086e18d377a86a1c46274a5e0ac117005662d2ca
CommitMsg: use apply() instead of commit()

FilePath: src/main/java/com/owncloud/android/ui/activity/Preferences.java**
```diff
         editor.putString(PreferenceKeys.INSTANT_VIDEO_UPLOAD_PATH, mUploadVideoPath);
-        editor.commit();
+        editor.apply();
```
ProjectName: 18141-syncthing-android
CommitID: 6ead7744b064ec254199dc96b1906bc26457c068
CommitMsg: Fixed lint warnings related to min API change.

FilePath: src/main/java/com/nutomic/syncthingandroid/syncthing/SyncthingService.java**
```diff
         if (!sp.getBoolean("default_user_pw_set", false)) {
-            sp.edit().putBoolean("default_user_pw_set", true).commit();
+            sp.edit().putBoolean("default_user_pw_set", true).apply();
```
ProjectName: 18141-syncthing-android
CommitID: 6ead7744b064ec254199dc96b1906bc26457c068
CommitMsg: Fixed lint warnings related to min API change.

FilePath: src/main/java/com/nutomic/syncthingandroid/syncthing/SyncthingService.java**
```diff
             sp.edit().putString("gui_user", user)
-                     .putString("gui_password", sb.toString()).commit();
+                     .putString("gui_password", sb.toString()).apply();
```
ProjectName: 18141-syncthing-android
CommitID: 6ead7744b064ec254199dc96b1906bc26457c068
CommitMsg: Fixed lint warnings related to min API change.

FilePath: src/main/java/com/nutomic/syncthingandroid/activities/MainActivity.java**
```diff
                     public void onClick(DialogInterface dialogInterface, int i) {
-                        sp.edit().putBoolean("first_start", false).commit();
+                        sp.edit().putBoolean("first_start", false).apply();
```
ProjectName: 5751-Conversations
CommitID: 4e898fa4f29e25cbd2fb7c4e0cdcc6342e88e417
CommitMsg: Run in background instead of writing instantaneously

FilePath: src/main/java/eu/siacs/conversations/ui/ConversationActivity.java**
```diff
 	private void setNeverAskForBatteryOptimizationsAgain() {
-		getPreferences().edit().putBoolean("show_battery_optimization", false).commit();
+		getPreferences().edit().putBoolean("show_battery_optimization", false).apply();
```
ProjectName: 16202-connectbot
CommitID: c729539884aa5249389f94c7bce42dd18e667794
CommitMsg: Use apply() instead of commit()

At API level 9 we can use this! The future!

FilePath: app/src/main/java/org/connectbot/SettingsActivity.java**
```diff
 			editor.clear();
-			editor.commit();
+			editor.apply();
```
ProjectName: 16202-connectbot
CommitID: c729539884aa5249389f94c7bce42dd18e667794
CommitMsg: Use apply() instead of commit()

At API level 9 we can use this! The future!

FilePath: app/src/androidTest/java/org/connectbot/StartupTest.java**
```diff
 		boolean wasAlwaysVisible = settings.getBoolean(PreferenceConstants.KEY_ALWAYS_VISIVLE, false);
-		editor.putBoolean(PreferenceConstants.KEY_ALWAYS_VISIVLE, true).commit();
+		editor.putBoolean(PreferenceConstants.KEY_ALWAYS_VISIVLE, true).apply();
```
