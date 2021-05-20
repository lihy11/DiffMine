###  infomation 
method del:
-org.apache.commons.logging.Log.error()
method add：
+org.apache.commons.logging.Log.warn()
###  support count
project count : 9
commit count : 14
###  code
ProjectName: 32143-checkstyle-idea
CommitID: 7d0b6ed67682cf1251afff53df6c433d23d9995e
CommitMsg: Changed log level to avoid spurious IDE error messages

FilePath: src/main/java/org/infernus/idea/checkstyle/model/ConfigurationLocation.java**
```diff
             } catch (Exception e) {
-                LOG.error("CheckStyle file could not be parsed for properties.", e);
+                LOG.warn("CheckStyle file could not be parsed for properties.", e);
```
ProjectName: 30753-phoenix
CommitID: f1c7fc879958be9a54b889d4e3fa3e6c9a10fc74
CommitMsg: Lower log level of static tracing initialization failure to warning

FilePath: phoenix-core/src/main/java/org/apache/phoenix/jdbc/PhoenixConnection.java**
```diff
         } catch (RuntimeException e) {
-            LOG.error("Tracing will outputs will not be written to any metrics sink! No "
+            LOG.warn("Tracing will outputs will not be written to any metrics sink! No "
```
ProjectName: 33465-sqoop
CommitID: 5ab5190304d0e13d1c5eaa56d1f486f3106529d3
CommitMsg: SQOOP-3420: Invalid ERROR message initiates false alarms

(Denes Bodo via Fero Szabo)
FilePath: src/java/org/apache/sqoop/orm/CompilationManager.java**
```diff
          *any reason.*/
-        LOG.error("Could not rename " + orig + " to " + dest + ". Error: " + e.getMessage());
+        LOG.warn("Could not rename " + orig + " to " + dest + ". Error: " + e.getMessage());
```
ProjectName: 22223-pdfbox
CommitID: fc1364c462710ab7e87f845a6aafee70274a10f5
CommitMsg: PDFBOX-3944: warn instead of error

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1810322 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/graphics/color/PDICCBased.java**
```diff
                 }
-                LOG.error("Can't read embedded ICC profile (" + e.getLocalizedMessage() + "), using alternate color space: " + alternateColorSpace.getName());
+                LOG.warn("Can't read embedded ICC profile (" + e.getLocalizedMessage() + 
+                         "), using alternate color space: " + alternateColorSpace.getName());
```
ProjectName: 22223-pdfbox
CommitID: 0efbd4ad92be20e375483567b9ba53710c779188
CommitMsg: PDFBOX-3722: make message less scary and more informative

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1787449 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/pdmodel/font/FileSystemFontProvider.java**
```diff
         {
-            LOG.error("Could not write to font cache", e);
+            LOG.warn("Could not write to font cache", e);
+            LOG.warn("Installed fonts information will have to be reloaded for each start");
+            LOG.warn("You can assign a directory to the 'pdfbox.fontcache' property");
```
ProjectName: 22223-pdfbox
CommitID: 616b403ab2b95355d02430d8aa7ee54399a9de37
CommitMsg: PDFBOX-3468: downgrade dash error log to warning

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1757212 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/contentstream/operator/state/SetLineDashPattern.java**
```diff
             {
-                LOG.error("dash array has non number element " + base + ", ignored");
+                LOG.warn("dash array has non number element " + base + ", ignored");
```
ProjectName: 22223-pdfbox
CommitID: 616b403ab2b95355d02430d8aa7ee54399a9de37
CommitMsg: PDFBOX-3468: downgrade dash error log to warning

git-svn-id: https://svn.apache.org/repos/asf/pdfbox/trunk@1757212 13f79535-47bb-0310-9956-ffa450edef68

FilePath: pdfbox/src/main/java/org/apache/pdfbox/contentstream/operator/state/SetLineDashPattern.java**
```diff
         {
-            LOG.error("dash lengths all zero, ignored");
+            LOG.warn("dash lengths all zero, ignored");
```
ProjectName: 23659-Kundera
CommitID: a281bcd93109bee3c4d88d83d48afd6fb7d7678f
CommitMsg: Changed ThriftDataHnadler for issue #201
and changed pelops client for some log

FilePath: kundera-cassandra/src/main/java/com/impetus/client/cassandra/pelops/PelopsClient.java**
```diff
             {
-                log.error("Error while finding relations, Caused by: ", e);
+                log.warn(e.getMessage());
```
ProjectName: 23659-Kundera
CommitID: a281bcd93109bee3c4d88d83d48afd6fb7d7678f
CommitMsg: Changed ThriftDataHnadler for issue #201
and changed pelops client for some log

FilePath: kundera-cassandra/src/main/java/com/impetus/client/cassandra/thrift/ThriftInvertedIndexHandler.java**
```diff
         {
-            log.error("Unable to search from inverted index, Caused by: ", e);
-            throw new IndexingException("Unable to search from inverted index", e);
+            log.warn("Not found any record in inverted index table");
```
ProjectName: 15118-spring-cloud-config
CommitID: 54f76bc2fd26732d09a51b16cbf7e3a57bb21d7f
CommitMsg: GH-193 logs warning if failFast is false

ConfigServicePropertySourceLocator should log a warning and not an error if failFast is false

FilePath: spring-cloud-config-client/src/main/java/org/springframework/cloud/config/client/ConfigServicePropertySourceLocator.java**
```diff
 		}
-		logger.error("Could not locate PropertySource: "
+		logger.warn("Could not locate PropertySource: "
```
ProjectName: 1272-flink
CommitID: bdcbb5e5a8db3615cad224e19f783615313fb140
CommitMsg: Fixed #258

FilePath: nephele/nephele-server/src/main/java/eu/stratosphere/nephele/taskmanager/runtime/RuntimeInputChannelContext.java**
```diff
 		if (buffer.remaining() > 0) {
-			LOG.error("consumedReadBuffer has " + buffer.remaining() + " unconsumed bytes left!!");
+			LOG.warn("ConsumedReadBuffer has " + buffer.remaining() + " unconsumed bytes left (early end of reading?).");
```
ProjectName: 6424-hbase
CommitID: 25c95d8dd9ec2d4e712aaeccedec306be41a3c8a
CommitMsg: HBASE-10906 Change error log for NamingException in TableInputFormatBase to WARN level



git-svn-id: https://svn.apache.org/repos/asf/hbase/trunk@1584890 13f79535-47bb-0310-9956-ffa450edef68

FilePath: hbase-server/src/main/java/org/apache/hadoop/hbase/mapreduce/TableInputFormatBase.java**
```diff
       } catch (NamingException e) {
-        LOG.error("Cannot resolve the host name for " + regionAddress + " because of " + e);
+        LOG.warn("Cannot resolve the host name for " + regionAddress + " because of " + e);
```
ProjectName: 13536-activemq
CommitID: b18255665f6b7b0e241d6f01019edcf5e1161c5c
CommitMsg: resolve: https://issues.apache.org/activemq/browse/AMQ-2125 - remove the error log, replace with warn as these are can ocurr on failover in normal usage, but are indicative of another consumer getting the message

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@982990 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/broker/region/PrefetchSubscription.java**
```diff
                 if (!callDispatchMatched) {
-                    LOG.error("Could not correlate acknowledgment with dispatched message: "
+                    LOG.warn("Could not correlate acknowledgment with dispatched message: "
```
ProjectName: 13536-activemq
CommitID: 504bcf0596693070d9c1deb00a6ef2c6455ecf3d
CommitMsg: demote log error or async exception to warn, with sendFailIfNoSpace, logs gets spammed with expected error messages

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@742603 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-core/src/main/java/org/apache/activemq/broker/TransportConnection.java**
```diff
             try {
-                SERVICELOG.error("Async error occurred: " + e, e);
+                SERVICELOG.warn("Async error occurred: " + e, e);
```
