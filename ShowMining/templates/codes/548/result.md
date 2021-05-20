###  infomation 
method del:
-org.apache.logging.log4j.Logger.info()
method add：
+org.apache.logging.log4j.Logger.debug()
###  support count
project count : 3
commit count : 13
###  code
ProjectName: 41143-sitewhere
CommitID: 991b27f32714bc015789e11e3e43a478ae90f639
CommitMsg: Log Solr queries to debug rather than info to prevent log bloat.
FilePath: sitewhere-solr/src/main/java/com/sitewhere/solr/search/SolrSearchProvider.java**
```diff
 	try {
-	    LOGGER.info("About to execute Solr search with query string: " + queryString);
+	    LOGGER.debug("About to execute Solr search with query string: " + queryString);
```
ProjectName: 41143-sitewhere
CommitID: 991b27f32714bc015789e11e3e43a478ae90f639
CommitMsg: Log Solr queries to debug rather than info to prevent log bloat.
FilePath: sitewhere-solr/src/main/java/com/sitewhere/solr/search/SolrSearchProvider.java**
```diff
 	try {
-	    LOGGER.info("About to execute Solr search with query string: " + queryString);
+	    LOGGER.debug("About to execute Solr search with query string: " + queryString);
```
ProjectName: 41143-sitewhere
CommitID: 1e22d4d716a56a3e70334ac25be8a201138bded9
CommitMsg: Only log resource caching if level is debug.
FilePath: sitewhere-core/src/main/java/com/sitewhere/server/resource/FileSystemResourceManager.java**
```diff
 		getGlobalResourceMap().put(relativePath, resource);
-		LOGGER.info("Cached resource: " + resource.getPath() + " (" + resource.getResourceType().name() + ") "
+		LOGGER.debug("Cached resource: " + resource.getPath() + " (" + resource.getResourceType().name() + ") "
```
ProjectName: 41143-sitewhere
CommitID: 1e22d4d716a56a3e70334ac25be8a201138bded9
CommitMsg: Only log resource caching if level is debug.
FilePath: sitewhere-core/src/main/java/com/sitewhere/server/resource/FileSystemResourceManager.java**
```diff
 		tenant.put(relativePath, resource);
-		LOGGER.info("Cached resource: " + resource.getPath() + " (" + resource.getResourceType().name() + ") "
+		LOGGER.debug("Cached resource: " + resource.getPath() + " (" + resource.getResourceType().name() + ") "
```
ProjectName: 25060-elasticsearch-readonlyrest-plugin
CommitID: 468145ef04cb0a9264ea30b6df1a4e9245d4c467
CommitMsg: lower log noise

FilePath: src/main/java/org/elasticsearch/plugin/readonlyrest/acl/requestcontext/Delayed.java**
```diff
 
-    logger.info(name + " > Committing " + effects.size() + " effects");
+    logger.debug(name + " > Committing " + effects.size() + " effects");
```
ProjectName: 25060-elasticsearch-readonlyrest-plugin
CommitID: 468145ef04cb0a9264ea30b6df1a4e9245d4c467
CommitMsg: lower log noise

FilePath: src/main/java/org/elasticsearch/plugin/readonlyrest/acl/requestcontext/Delayed.java**
```diff
       finally {
-        logger.info(name + " > committed.");
+        logger.debug(name + " > committed.");
```
ProjectName: 25060-elasticsearch-readonlyrest-plugin
CommitID: 468145ef04cb0a9264ea30b6df1a4e9245d4c467
CommitMsg: lower log noise

FilePath: src/main/java/org/elasticsearch/plugin/readonlyrest/acl/requestcontext/Delayed.java**
```diff
   public void reset() {
-    logger.info(name + " > resetting!!! ");
+    logger.debug(name + " > resetting!!! ");
```
ProjectName: 25060-elasticsearch-readonlyrest-plugin
CommitID: 74a87482ee61cbbd5a6466736b69dfce02288e5c
CommitMsg: fix rewrite + remove debug logs

FilePath: src/main/java/org/elasticsearch/plugin/readonlyrest/acl/requestcontext/Transactional.java**
```diff
       if (transientValue == null && initialValue == null || transientValue.equals(initialValue)) {
-        logger.info(name + " > nothing to be committed..");
+        logger.debug(name + " > nothing to be committed..");
```
ProjectName: 25060-elasticsearch-readonlyrest-plugin
CommitID: 74a87482ee61cbbd5a6466736b69dfce02288e5c
CommitMsg: fix rewrite + remove debug logs

FilePath: src/main/java/org/elasticsearch/plugin/readonlyrest/acl/requestcontext/Transactional.java**
```diff
       }
-      logger.info(name + " > committing final value " + transientValue);
+      logger.debug(name + " > committing final value " + transientValue);
```
ProjectName: 25060-elasticsearch-readonlyrest-plugin
CommitID: 74a87482ee61cbbd5a6466736b69dfce02288e5c
CommitMsg: fix rewrite + remove debug logs

FilePath: src/main/java/org/elasticsearch/plugin/readonlyrest/acl/requestcontext/Transactional.java**
```diff
     transientValue = copy(this.initialValue);
-    logger.info(name + " > lazy loading initial value to " + initialValue);
+    logger.debug(name + " > lazy loading initial value to " + initialValue);
```
ProjectName: 25060-elasticsearch-readonlyrest-plugin
CommitID: 74a87482ee61cbbd5a6466736b69dfce02288e5c
CommitMsg: fix rewrite + remove debug logs

FilePath: src/main/java/org/elasticsearch/plugin/readonlyrest/acl/requestcontext/Delayed.java**
```diff
     }
-    logger.info(name + " > Committing " + effects.size() + " effects");
+    logger.debug(name + " > Committing " + effects.size() + " effects");
```
ProjectName: 13882-blynk-server
CommitID: 8390f4202467a07f9e9336a631c983dfb224e314
CommitMsg: less logging for known issue

FilePath: server/tcp-hardware-server/src/main/java/cc/blynk/server/hardware/handlers/hardware/auth/HardwareLoginHandler.java**
```diff
         } else {
-            log.info("Redirecting token '{}' to {}", token, server);
+            log.debug("Redirecting token '{}' to {}", token, server);
```
ProjectName: 13882-blynk-server
CommitID: 5c465b4de35d39d28fed6196184d5a6fa6e8328b
CommitMsg: less logging for http

FilePath: server/http-core/src/main/java/cc/blynk/core/http/BaseHttpHandler.java**
```diff
 
-        log.info("{} : {}", req.method().name(), req.uri());
+        log.debug("{} : {}", req.method().name(), req.uri());
```
