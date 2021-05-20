###  infomation 
method del:
-java.util.LinkedList.size()
method add：
+java.util.LinkedList.isEmpty()
###  support count
project count : 6
commit count : 15
###  code
ProjectName: 25999-geotools
CommitID: b846c87cf53b9c61bd4fe6fd23999071c5750089
CommitMsg: Make sure `PartiallyOrderedSet` works when empty

FilePath: modules/library/metadata/src/main/java/org/geotools/util/PartiallyOrderedSet.java**
```diff
             }
-            if(sources.size() == 0) {
+            if(!elementsToNodes.isEmpty() && sources.isEmpty()) {
```
ProjectName: 6355-jodd
CommitID: 54b19c656d5dde1df4d4034c8026839ee9909d3e
CommitMsg: Merge pull request #288 from DevFactory/release/Collection.isEmpty()-should-be-used-to-test-for-emptiness,-Nested-enums-should-not-be-declared-static-fix-1

squid:S1155, squid:S2786 - Collection.isEmpty() should be used to tes…
FilePath: jodd-http/src/main/java/jodd/http/Buffer.java**
```diff
 	public Buffer append(Buffer buffer) {
-		if (buffer.list.size() == 0) {
+		if (buffer.list.isEmpty()) {
```
ProjectName: 6355-jodd
CommitID: bbd5c04921579fccbdeed06775cdda088c35abfb
CommitMsg: squid:S1155, squid:S2786 - Collection.isEmpty() should be used to test for emptiness, Nested enums should not be declared static

FilePath: jodd-http/src/main/java/jodd/http/Buffer.java**
```diff
 	public Buffer append(Buffer buffer) {
-		if (buffer.list.size() == 0) {
+		if (buffer.list.isEmpty()) {
```
ProjectName: 5607-atmosphere
CommitID: 9b29a2dcd4bff276f3408d29989cef5efd9e954d
CommitMsg: add more pmd checks

FilePath: modules/jersey/src/main/java/org/atmosphere/jersey/AtmosphereFilter.java**
```diff
 
-        if (list.size() == 0) {
+        if (!list.isEmpty()) {
```
ProjectName: 5607-atmosphere
CommitID: 9b29a2dcd4bff276f3408d29989cef5efd9e954d
CommitMsg: add more pmd checks

FilePath: modules/cpr/src/main/java/org/atmosphere/inject/InjectableObjectFactory.java**
```diff
                 Object instance = null;
-                while (pushBackInjection.size() > 0 & maxTry-- > 0) {
+                while (!pushBackInjection.isEmpty() & maxTry-- > 0) {
```
ProjectName: 5607-atmosphere
CommitID: 9b29a2dcd4bff276f3408d29989cef5efd9e954d
CommitMsg: add more pmd checks

FilePath: modules/cpr/src/main/java/org/atmosphere/inject/InjectableObjectFactory.java**
```diff
 
-                if (pushBackInjection.size() > 0) {
+                if (!pushBackInjection.isEmpty()) {
```
ProjectName: 7518-libstreaming
CommitID: 3a7a52fbd54a3f81b1f62a580c7a66e93c0e79e3
CommitMsg: Merge pull request #189 from DevFactory/release/general-code-quality-fix-1

General code quality fix-1
FilePath: src/net/majorkernelpanic/streaming/rtsp/RtspServer.java**
```diff
 		synchronized (mListeners) {
-			if (mListeners.size() > 0) {
+			if (!mListeners.isEmpty()) {
```
ProjectName: 7518-libstreaming
CommitID: 3a7a52fbd54a3f81b1f62a580c7a66e93c0e79e3
CommitMsg: Merge pull request #189 from DevFactory/release/general-code-quality-fix-1

General code quality fix-1
FilePath: src/net/majorkernelpanic/streaming/rtsp/RtspServer.java**
```diff
 		synchronized (mListeners) {
-			if (mListeners.size() > 0) {
+			if (!mListeners.isEmpty()) {
```
ProjectName: 7518-libstreaming
CommitID: 3a7a52fbd54a3f81b1f62a580c7a66e93c0e79e3
CommitMsg: Merge pull request #189 from DevFactory/release/general-code-quality-fix-1

General code quality fix-1
FilePath: src/net/majorkernelpanic/streaming/rtsp/RtspServer.java**
```diff
 		synchronized (mListeners) {
-			if (mListeners.size() > 0) {
+			if (!mListeners.isEmpty()) {
```
ProjectName: 7518-libstreaming
CommitID: fefcf29fb175d24cb36e76c1bad995c870aa3d78
CommitMsg: Fixing squid:S1155, squid:S1126

FilePath: src/net/majorkernelpanic/streaming/rtsp/RtspServer.java**
```diff
 		synchronized (mListeners) {
-			if (mListeners.size() > 0) {
+			if (!mListeners.isEmpty()) {
```
ProjectName: 7518-libstreaming
CommitID: fefcf29fb175d24cb36e76c1bad995c870aa3d78
CommitMsg: Fixing squid:S1155, squid:S1126

FilePath: src/net/majorkernelpanic/streaming/rtsp/RtspServer.java**
```diff
 		synchronized (mListeners) {
-			if (mListeners.size() > 0) {
+			if (!mListeners.isEmpty()) {
```
ProjectName: 7518-libstreaming
CommitID: fefcf29fb175d24cb36e76c1bad995c870aa3d78
CommitMsg: Fixing squid:S1155, squid:S1126

FilePath: src/net/majorkernelpanic/streaming/rtsp/RtspServer.java**
```diff
 		synchronized (mListeners) {
-			if (mListeners.size() > 0) {
+			if (!mListeners.isEmpty()) {
```
ProjectName: 7606-opengrok
CommitID: c9ce9a97fff03e6bacd29569108fd45c9765dd57
CommitMsg: Use isEmpty() instead of size() to check whether a list is empty

FilePath: src/org/opensolaris/opengrok/web/Util.java**
```diff
                 if (names[i].equals("..")) {
-                    if (res.size() > 0) {
+                    if (!res.isEmpty()) {
```
ProjectName: 5818-jmeter
CommitID: b1eb4ccd61411c445c6bf341717f2a56b40f42f6
CommitMsg: Use isEmpty instead of size.

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1773595 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 3fedbde384ecc8224ea2644ee090b693870e9a5a
FilePath: src/core/org/apache/jmeter/threads/TestCompiler.java**
```diff
         stack.removeLast();
-        if (stack.size() > 0) {
+        if (!stack.isEmpty()) {
```
ProjectName: 5818-jmeter
CommitID: 27c8d7f901576d17f835a26be0c572d95383c390
CommitMsg: size can be an expensive operation on a collection, so use isEmpty instead.

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1719795 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: d15dceee9380e2877a6191121d9bbbe4e906873a
FilePath: src/core/org/apache/jmeter/report/processor/ExternalSampleSorter.java**
```diff
     public void stopConsuming() {
-        if (samples.size() > 0) {
+        if (!samples.isEmpty()) {
```
