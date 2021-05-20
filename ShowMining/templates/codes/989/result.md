###  infomation 
method del:
-java.util.List.add()
method add：
+java.util.List.addAll()
###  support count
project count : 16
commit count : 17
###  code
ProjectName: 38527-giraph
CommitID: 6f8296d9e3f0e23fb69999f61a8161b1f5e8b13b
CommitMsg: GIRAPH-175. Replace manual array copy to utility method call. Contributed by Devaraj K.


git-svn-id: https://svn.apache.org/repos/asf/incubator/giraph/trunk@1327344 13f79535-47bb-0310-9956-ffa450edef68

FilePath: src/main/java/org/apache/giraph/zk/ZooKeeperManager.java**
```diff
       if (zkJavaOptsArray != null) {
-        for (String javaOpt : zkJavaOptsArray) {
-          commandList.add(javaOpt);
-        }
+        commandList.addAll(Arrays.asList(zkJavaOptsArray));
```
ProjectName: 21551-struts
CommitID: b382c5c021fc7c79b7c6d47f41d09a2307b2adb1
CommitMsg: WW-3803 improves support for JAR inside EAR package when used with JBoss 7

git-svn-id: https://svn.apache.org/repos/asf/struts/struts2/trunk@1331373 13f79535-47bb-0310-9956-ffa450edef68

FilePath: xwork-core/src/main/java/com/opensymphony/xwork2/util/finder/UrlSet.java**
```diff
             if (URLUtil.isJBossUrl(url)) {
-                list.add(URLUtil.getJBossPhysicalUrl(url));
+                list.addAll(URLUtil.getAllJBossPhysicalUrls(url));
```
ProjectName: 22318-carbondata
CommitID: 01115872efc5eaa87886ca53f85dc680752fb750
CommitMsg: [CARBONDATA-2834] Remove unnecessary nested looping over loadMetadatadetails.

removed nested for loop which causes query performance degradation if there are huge number of entries for compacted segments in tablestatus file.

This closes #2612

FilePath: hadoop/src/main/java/org/apache/carbondata/hadoop/api/CarbonTableInputFormat.java**
```diff
       invalidSegments.addAll(segments.getInvalidSegments());
-      for (Segment invalidSegmentId : invalidSegments) {
-        invalidTimestampsList
-            .add(updateStatusManager.getInvalidTimestampRange(invalidSegmentId.getSegmentNo()));
-      }
+      invalidTimestampsList.addAll(updateStatusManager.getInvalidTimestampRange());
```
ProjectName: 23045-UniversalMediaServer
CommitID: 34b78c90ef2190e741b9169c89b6d5707de73637
CommitMsg: Fix custom option parsing for ffmpeg_gpu_decoding_acceleration_method (#1748)

ProcessBuilder would quote the provided custom options, which breaks ffmpeg.

Splitting the commands ensures that this:
ffmpeg -y -loglevel fatal "-hwaccel vaapi -vaapi_device /dev/dri/renderD128" (...)

Becomes this:
ffmpeg -y -loglevel fatal -hwaccel vaapi -vaapi_device /dev/dri/renderD128 (...)

As expected.
FilePath: src/main/java/net/pms/encoders/FFMpegVideo.java**
```diff
 				if (configuration.getFFmpegGPUDecodingAccelerationMethod().matches(".*-hwaccel +[a-z]+.*")) {
-					cmdList.add(configuration.getFFmpegGPUDecodingAccelerationMethod());
+					String[] hwaccelOptions = StringUtils.split(configuration.getFFmpegGPUDecodingAccelerationMethod());
+					cmdList.addAll(Arrays.asList(hwaccelOptions));
```
ProjectName: 25586-opennlp
CommitID: f545a85f56418147c1712ff4d08fcfcf35c09745
CommitMsg: OPENNLP-363 Simplified a loop. Thanks to Aliaksandr Autayeu for providing a patch.

git-svn-id: https://svn.apache.org/repos/asf/incubator/opennlp/trunk@1199660 13f79535-47bb-0310-9956-ffa450edef68

FilePath: opennlp-tools/src/main/java/opennlp/tools/formats/ad/ADNameSampleStream.java**
```diff
           if(lexemes.length > 1) {
-            for (int i = 0; i < lexemes.length - 1; i++) {
-              sentence.add(lexemes[i]);
-            }
+             sentence.addAll(Arrays.asList(lexemes).subList(0, lexemes.length - 1));
```
ProjectName: 26208-logback-android
CommitID: 2b2edb0cc0d0e8c3f8c26a39e40811181aa4f632
CommitMsg: Allow multiple recipient address in 1 <to> element in SMTPAppender (LBCORE-213)

FilePath: logback-core/src/main/java/ch/qos/logback/core/net/SMTPAppenderBase.java**
```diff
         InternetAddress[] tmp = InternetAddress.parse(email, true);
-        // one <To> element should contain one email address
-        iaList.add(tmp[0]);
+        iaList.addAll(Arrays.asList(tmp));
```
ProjectName: 10166-Anki-Android
CommitID: d6ab2c8f09f98d25b21bf7550438cdda0d7be6c1
CommitMsg: Manual array to collection copy replaced with addAll.

FilePath: src/com/ichi2/libanki/Utils.java**
```diff
         List<File> decks = new ArrayList<File>();
-        for (int i = 0; i < deckCount; i++) {
-        	decks.add(deckList[i]);
-        }
+        decks.addAll(Arrays.asList(deckList).subList(0, deckCount));
```
ProjectName: 11670-maven
CommitID: 4f2c5b4511f6d447d858757be9f63e620a95c8ae
CommitMsg: o Fixed mirror handling

git-svn-id: https://svn.apache.org/repos/asf/maven/components/trunk@786899 13f79535-47bb-0310-9956-ffa450edef68

FilePath: maven-core/src/main/java/org/apache/maven/project/DefaultMavenProjectBuilder.java**
```diff
                     {
-                        repos.add( repositorySystem.buildArtifactRepository( (Repository) repository ) );
+                        ArtifactRepository repo = repositorySystem.buildArtifactRepository( (Repository) repository );
+                        repos.addAll( repositorySystem.getMirrors( Arrays.asList( repo ) ) );
```
ProjectName: 10395-jitsi
CommitID: 20edb99ab54e1479345e4c34c3e912cf5ebf6819
CommitMsg: Fixed type
Removed redundant initialization
Used addAll() instead of a manual arrayCopy

FilePath: src/net/java/sip/communicator/impl/neomedia/MediaServiceImpl.java**
```diff
             screenList = new ArrayList<ScreenDevice>(screens.length);
-            for (ScreenDevice screen : screens)
-                screenList.add(screen);
+            screenList.addAll(Arrays.asList(screens));
```
ProjectName: 2042-jsoup
CommitID: ad4a1bee132ee7d1167ac795407345f2bc6a1db8
CommitMsg: Minor inspections

FilePath: src/main/java/org/jsoup/nodes/Document.java**
```diff
                 Node dupe = elements.get(i);
-                for (Node node : dupe.childNodes)
-                    toMove.add(node);
+                toMove.addAll(dupe.childNodes);
```
ProjectName: 2042-jsoup
CommitID: ad4a1bee132ee7d1167ac795407345f2bc6a1db8
CommitMsg: Minor inspections

FilePath: src/main/java/org/jsoup/nodes/Node.java**
```diff
 
-        for (Node child: childNodes)
-            clone.childNodes.add(child);
+        clone.childNodes.addAll(childNodes);
```
ProjectName: 7611-Terasology
CommitID: 903557bbe9e624624ec2cb1915bd8b985d232ada
CommitMsg: New ArrayList isn't created anymore in the update loop.

FilePath: engine/src/main/java/org/terasology/rendering/nui/layers/mainMenu/SelectModulesScreen.java**
```diff
                         sortedModules.add(-pos - 1, info);     // use "insertion point" to keep the list sorted
-                        allSortedModules = new ArrayList<>(sortedModules);
+                        allSortedModules.clear();
+                        allSortedModules.addAll(sortedModules);
```
ProjectName: 5844-jOOQ
CommitID: e07671ab20e74dfa4abdfcf1d24f9aa23cf43eba
CommitMsg: Release 3.0.0-RC1 - Small optimisation
FilePath: jOOQ/src/main/java/org/jooq/impl/Utils.java**
```diff
 
-        for (ExecuteListener listener : configuration.getExecuteListeners()) {
-            result.add(listener);
-        }
-
+        result.addAll(configuration.getExecuteListeners());
```
ProjectName: 4607-hibernate-orm
CommitID: d0bd04b6d3fb65e753b9103e9babeb14aa4c7ffa
CommitMsg: HHH-13496 Prefer #addAll method usage rather than looping

FilePath: hibernate-core/src/main/java/org/hibernate/hql/internal/classic/QueryTranslatorImpl.java**
```diff
 			rtsize = returnedTypes.size();
-			Iterator iter = entitiesToFetch.iterator();
-			while ( iter.hasNext() ) {
-				returnedTypes.add( iter.next() );
-			}
+			returnedTypes.addAll( entitiesToFetch );
```
ProjectName: 8346-pmd
CommitID: ea6174ebeddbd0a645a81895d9be7a48ae1b7f1c
CommitMsg: Fix computation of metrics with annotations

FilePath: pmd-java/src/main/java/net/sourceforge/pmd/lang/java/metrics/impl/AbstractJavaClassMetric.java**
```diff
         for (ASTAnyTypeBodyDeclaration decl : decls) {
-            if (decl.jjtGetNumChildren() > 0 && tClass.isInstance(decl.jjtGetChild(0))) {
-                result.add(tClass.cast(decl.jjtGetChild(0)));
-            }
+            result.addAll(decl.findChildrenOfType(tClass));
```
ProjectName: 35532-cxf
CommitID: cbf0ca69edb54ce58fc8063dfaa03fa497004ec6
CommitMsg: [CXF-7310] Updating ClientProxyImpl to parse individual accept values same was it is done with Path

FilePath: rt/rs/client/src/main/java/org/apache/cxf/jaxrs/client/ClientProxyImpl.java**
```diff
         for (String s : headers) {
-            types.add(JAXRSUtils.toMediaType(s));
+            types.addAll(JAXRSUtils.parseMediaTypes(s));
```
ProjectName: 38627-presto
CommitID: b62825f719640e8888ff0a267ffad8646dd06c35
CommitMsg: Remove manual array to collection copy

FilePath: presto-spi/src/main/java/io/prestosql/spi/predicate/SortedRangeSet.java**
```diff
         rangeList.add(first);
-        for (Range range : rest) {
-            rangeList.add(range);
-        }
+        rangeList.addAll(asList(rest));
```
