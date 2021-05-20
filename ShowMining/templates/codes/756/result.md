###  infomation 
method del:
-null.e()
method add：
+null.i()
###  support count
project count : 5
commit count : 15
###  code
ProjectName: 40806-libaums
CommitID: c3272d78dfecb5772727bead668d37ee4cf028c3
CommitMsg: info instead of warning


FilePath: libaums/src/main/java/com/github/mjdev/libaums/UsbMassStorageDevice.java**
```diff
 		deviceConnection.controlTransfer(0b10100001, 0b11111110, 0, usbInterface.getId(), b, 1, 5000);
-		Log.e(TAG, "MAX LUN " + (int)b[0]);
+		Log.i(TAG, "MAX LUN " + (int)b[0]);
```
ProjectName: 48239-collect
CommitID: e73ef8b9e45d0755bf8f10245e277fb11d86f997
CommitMsg: Changed Tiber.e to Tiber.i in the discardEntityBytes method (#1232)


FilePath: collect_app/src/main/java/org/odk/collect/android/utilities/WebUtils.java**
```diff
             } catch (Exception e) {
-                Timber.e(e);
+                Timber.i(e);
```
ProjectName: 48239-collect
CommitID: 372cfdf97df53cadf69c27d5ecad6a1f4616d0f2
CommitMsg: Removes error level logs for normal conditions (#1164)


FilePath: collect_app/src/main/java/org/odk/collect/android/activities/FormEntryActivity.java**
```diff
             case PROGRESS_DIALOG:
-                Timber.e("Creating PROGRESS_DIALOG");
+                Timber.i("Creating PROGRESS_DIALOG");
```
ProjectName: 48239-collect
CommitID: 372cfdf97df53cadf69c27d5ecad6a1f4616d0f2
CommitMsg: Removes error level logs for normal conditions (#1164)


FilePath: collect_app/src/main/java/org/odk/collect/android/activities/FormEntryActivity.java**
```diff
             case SAVING_DIALOG:
-                Timber.e("Creating SAVING_DIALOG");
+                Timber.i("Creating SAVING_DIALOG");
```
ProjectName: 48239-collect
CommitID: 372cfdf97df53cadf69c27d5ecad6a1f4616d0f2
CommitMsg: Removes error level logs for normal conditions (#1164)


FilePath: collect_app/src/main/java/org/odk/collect/android/activities/FormEntryActivity.java**
```diff
     private void dismissDialogs() {
-        Timber.e("Dismiss dialogs");
+        Timber.i("Dismiss dialogs");
```
ProjectName: 48239-collect
CommitID: b0c275d7d30fc45c85389dc97fd75d519aa4faec
CommitMsg: minor cleanup of formhandler, uploadertask

FilePath: src/org/odk/collect/android/UploaderTask.java**
```diff
             MultipartEntity entity = new MultipartEntity();
-            Log.e(t, "# of files " + files.length);
+            Log.i(t, "# of files " + files.length);
```
ProjectName: 20057-AnySoftKeyboard
CommitID: fa2d968fa79b2711f2a7092ef47933d11d1dae42
CommitMsg: fix for issue #136

FilePath: src/com/anysoftkeyboard/dictionaries/BTreeDictionary.java**
```diff
             if (word.length() >= MAX_WORD_LENGTH) return false;
-            Log.e(TAG, "Adding word '" + word + "' to dictionary (in " + getClass().getSimpleName() + ") with frequency " + frequency);
+
+            Log.i(TAG, "Adding word '" + word + "' to dictionary (in " + getClass().getSimpleName() + ") with frequency " + frequency);
+            //first deleting the word, so it wont conflict in the adding (_ID is unique).
+            deleteWord(word);
```
ProjectName: 28890-rtmp-rtsp-stream-client-java
CommitID: 6d0488692a8bbe87facb9650010cbaf095559433
CommitMsg: change logs

FilePath: rtmp/src/main/java/net/ossrs/rtmp/SrsFlvMuxer.java**
```diff
         mFlvTagCache.clear();
-        Log.e(TAG, "frame discarded, cant add more frame: ", e);
+        Log.i(TAG, "frame discarded");
```
ProjectName: 28890-rtmp-rtsp-stream-client-java
CommitID: 6d0488692a8bbe87facb9650010cbaf095559433
CommitMsg: change logs

FilePath: encoder/src/main/java/com/pedro/encoder/video/VideoEncoder.java**
```diff
         queue.clear();
-        Log.e(TAG, "frame discarded, cant add more frames: ", e);
+        Log.i(TAG, "frame discarded");
```
ProjectName: 28890-rtmp-rtsp-stream-client-java
CommitID: 6d0488692a8bbe87facb9650010cbaf095559433
CommitMsg: change logs

FilePath: encoder/src/main/java/com/pedro/encoder/video/VideoEncoder.java**
```diff
         queue.clear();
-        Log.e(TAG, "frame discarded, cant add more frames: ", e);
+        Log.i(TAG, "frame discarded");
```
ProjectName: 28890-rtmp-rtsp-stream-client-java
CommitID: 1023976af765f0ca567c664c8c647903616424a3
CommitMsg: fix queue nullpointer

FilePath: rtsp/src/main/java/com/pedro/rtsp/rtsp/RtspClient.java**
```diff
             } else {
-              Log.e("Ports", s[i]);
+              Log.i("Ports", s[i]);
```
ProjectName: 28890-rtmp-rtsp-stream-client-java
CommitID: 1023976af765f0ca567c664c8c647903616424a3
CommitMsg: fix queue nullpointer

FilePath: rtsp/src/main/java/com/pedro/rtsp/rtsp/RtspClient.java**
```diff
     authorization = createAuth(authResponse);
-    Log.e("Auth", authorization);
+    Log.i("Auth", authorization);
```
ProjectName: 28890-rtmp-rtsp-stream-client-java
CommitID: 58256362bb713e7d463652ac2bfc5d2ddd546329
CommitMsg: minor change rtmp module

FilePath: rtmp/src/main/java/com/github/faucamp/simplertmp/io/RtmpConnection.java**
```diff
               "description")).getValue();
-          Log.e("Pedro", description);
+          Log.i(TAG, description);
```
ProjectName: 28890-rtmp-rtsp-stream-client-java
CommitID: 58256362bb713e7d463652ac2bfc5d2ddd546329
CommitMsg: minor change rtmp module

FilePath: rtmp/src/main/java/com/github/faucamp/simplertmp/io/RtmpConnection.java**
```diff
 
-        Log.e(TAG, "handleRxInvoke: Got result for invoked method: " + method);
+        Log.i(TAG, "handleRxInvoke: Got result for invoked method: " + method);
```
ProjectName: 10166-Anki-Android
CommitID: 43253b4e64ec6473c3322c03e1dc3150a30d436f
CommitMsg: better log level and message

FilePath: src/com/ichi2/anki/Deck.java**
```diff
             fillFailedQueueMethod.invoke(Deck.this);
-            Log.e(AnkiDroidApp.TAG, "made it!");
+            Log.i(AnkiDroidApp.TAG, "fillFailedQueueMethod invoked");
```
