###  infomation 
method del:
-java.io.File.toURL()
method add：
+java.io.File.toURI()
+java.net.URI.toURL()
###  support count
project count : 13
commit count : 35
###  code
ProjectName: 33715-openhtmltopdf
CommitID: f17a412f6a59ba71ee9e7f23e130693abda882b2
CommitMsg: documentFromString() treated string as system identifier

(also, fix deprecated toURL() call)

FilePath: src/java/org/xhtmlrenderer/util/XMLUtil.java**
```diff
 
-        return createDocumentBuilder().parse(new File(filename).toURL().openStream());
+        return createDocumentBuilder().parse(new File(filename).toURI().toURL().openStream());
```
ProjectName: 33715-openhtmltopdf
CommitID: b4fcd4d2280a72e6c2b30b1a84a62180a4658869
CommitMsg: remove ref to depr. method

FilePath: demos/samples/src/ImageRender.java**
```diff
 				// compare to old
-				BufferedImage img = Graphics2DRenderer.renderToImage(f.toURL().toExternalForm(), 1024);
+				BufferedImage img = Graphics2DRenderer.renderToImage(f.toURI().toURL().toExternalForm(), 1024);
```
ProjectName: 21551-struts
CommitID: 32bee13a05fad35df8d2b68d6f5ce5e0e721a260
CommitMsg: WW-2883 StrutsXmlConfigurationProvider generics fix
- applied patch submitted by Mathias Bogaert

git-svn-id: https://svn.apache.org/repos/asf/struts/struts2/trunk@747063 13f79535-47bb-0310-9956-ffa450edef68

FilePath: core/src/main/java/org/apache/struts2/config/StrutsXmlConfigurationProvider.java**
```diff
             try {
-                url = file.toURL();
+                url = file.toURI().toURL();
```
ProjectName: 21551-struts
CommitID: 1ac171221aab8ff57985d524fa1752c6bbd97c74
CommitMsg: WW-2883 StrutsXmlConfigurationProvider generics fix
- applied patch submitted by Mathias Bogaert

git-svn-id: https://svn.apache.org/repos/asf/struts/struts2/trunk@747044 13f79535-47bb-0310-9956-ffa450edef68

FilePath: core/src/main/java/org/apache/struts2/config/StrutsXmlConfigurationProvider.java**
```diff
             try {
-                url = file.toURL();
+                url = file.toURI().toURL();
```
ProjectName: 37503-sonar-java
CommitID: 3dae2b9cd1ee180902b929c3a44df27e9e369bcb
CommitMsg: Do not use File#toURL (marked as deprecated in JDK 1.6)

FilePath: java-squid/src/main/java/org/sonar/java/bytecode/loader/FileSystemLoader.java**
```diff
       try {
-        return file.toURL();
+        return file.toURI().toURL();
```
ProjectName: 26208-logback-android
CommitID: 2f4481a2149518245ba8fd984ed09ab634fda7f2
CommitMsg: very minor changes

FilePath: logback-core/src/main/java/ch/qos/logback/core/joran/GenericConfigurator.java**
```diff
     try {
-      informContextOfURLUsedForConfiguration(file.toURL());
+      informContextOfURLUsedForConfiguration(file.toURI().toURL());
```
ProjectName: 26208-logback-android
CommitID: 387ecabe2a460783d50166f755e5b9ad100e044b
CommitMsg: - file.toURL was deprecated in JDK 1.6

FilePath: logback-classic/src/main/java/ch/qos/logback/classic/util/ContextInitializer.java**
```diff
           try {
-            result = f.toURL();
+            result = f.toURI().toURL();
```
ProjectName: 26506-spoon
CommitID: 54e1909ab7217cd8417d4d15cc7c0d127750b474
CommitMsg: refactor: remove call to deprecated File#toURL (#1313)


FilePath: src/main/java/spoon/support/reflect/declaration/CtClassImpl.java**
```diff
 		NewInstanceClassloader(File binaryOutputDirectory) throws MalformedURLException {
-			super(new URL[] { binaryOutputDirectory.toURL()});
+			super(new URL[] { binaryOutputDirectory.toURI().toURL()});
```
ProjectName: 10395-jitsi
CommitID: 4359c1e8c84bebf5ffb328571770321b77fc36ea
CommitMsg: Fix opening received files with space in the name, in incoming file transfer.

FilePath: src/net/java/sip/communicator/impl/osdependent/Desktop.java**
```diff
                     if (!file.isDirectory())
-                        org.jdesktop.jdic.desktop.Desktop.browse(file.toURL());
+                        org.jdesktop.jdic.desktop.Desktop.browse(
+                            file.toURI().toURL());
```
ProjectName: 10395-jitsi
CommitID: 830a8a3c9ca892bc28e0b249eec7534a1f589241
CommitMsg: Removing calls to deprecated File.toURL()


FilePath: src/net/java/sip/communicator/plugin/notificationconfiguration/NotificationConfigurationConfigForm.java**
```diff
                     //This is where a real application would open the file.
-                    logger.debug("Opening: " + file.toURL().toExternalForm());
-                    tmpNTE.setSoundFile(file.toURL().toExternalForm());
+                    logger.debug("Opening: " + file.toURI().toURL().toExternalForm());
+                    tmpNTE.setSoundFile(file.toURI().toURL().toExternalForm());
```
ProjectName: 10395-jitsi
CommitID: 830a8a3c9ca892bc28e0b249eec7534a1f589241
CommitMsg: Removing calls to deprecated File.toURL()


FilePath: src/net/java/sip/communicator/plugin/notificationconfiguration/NotificationConfigurationConfigForm.java**
```diff
                     notificationList.setLine(tmpNTE, index);
-                    soundFileTextField.setText(file.toURL().toExternalForm());
+                    soundFileTextField.setText(file.toURI().toURL().toExternalForm());
```
ProjectName: 10572-Openfire
CommitID: ee9e5f472e14c524b17fa160507a4b443c2acd07
CommitMsg: Replace deprecated toURL() with toURI().toURL() as per the JavaDoc

FilePath: src/java/org/jivesoftware/openfire/container/PluginManager.java**
```diff
                             dev.setClassesDir(classes);
-                            pluginLoader.addURLFile(classes.getAbsoluteFile().toURL());
+                            pluginLoader.addURLFile(classes.getAbsoluteFile().toURI().toURL());
```
ProjectName: 10572-Openfire
CommitID: ee9e5f472e14c524b17fa160507a4b443c2acd07
CommitMsg: Replace deprecated toURL() with toURI().toURL() as per the JavaDoc

FilePath: src/java/org/jivesoftware/openfire/launcher/Launcher.java**
```diff
 
-                    copy(plugin.toURL(), tempPluginsFile);
+                    copy(plugin.toURI().toURL(), tempPluginsFile);
```
ProjectName: 10572-Openfire
CommitID: d15c7a9b02450aab2f8d62e12b3b286091434e15
CommitMsg: OF-46: Fix space escaping

git-svn-id: http://svn.igniterealtime.org/svn/repos/openfire/trunk@11553 b35dd754-fafc-0310-a699-88a17e54d16e

FilePath: src/java/org/jivesoftware/openfire/starter/JiveClassLoader.java**
```diff
     JiveClassLoader(ClassLoader parent, File libDir) throws MalformedURLException {
-        super(new URL[] { libDir.toURL() }, parent);
+        super(new URL[] { libDir.toURI().toURL() }, parent);
```
ProjectName: 10572-Openfire
CommitID: d15c7a9b02450aab2f8d62e12b3b286091434e15
CommitMsg: OF-46: Fix space escaping

git-svn-id: http://svn.igniterealtime.org/svn/repos/openfire/trunk@11553 b35dd754-fafc-0310-a699-88a17e54d16e

FilePath: src/java/org/jivesoftware/openfire/starter/JiveClassLoader.java**
```diff
             if (jars[i].isFile()) {
-                addURL(jars[i].toURL());
+                addURL(jars[i].toURI().toURL());
```
ProjectName: 17362-WePush
CommitID: 2aee3a8b2de3685da8d81ba29ad11ecee56ecab7
CommitMsg: 代码0Warning

FilePath: src/main/java/com/fangxuele/tool/push/util/CharSetUtil.java**
```diff
         try {
-            charset = detector.detectCodepage(file.toURL());
+            charset = detector.detectCodepage(file.toURI().toURL());
```
ProjectName: 11281-liquibase
CommitID: 086005f549605da6775e9b6cb67f7fad218fa649
CommitMsg: Removing some of the deprecated method calls and replacing with their appropriate replacements.

FilePath: liquibase-core/src/main/java/liquibase/integration/ant/BaseLiquibaseTask.java**
```diff
         for (String string : strings) {
-            URL url = new File(string).toURL();
+            URL url = new File(string).toURI().toURL();
```
ProjectName: 11281-liquibase
CommitID: 46642b095ac1083c010664f79402ba5217908205
CommitMsg: Merge remote-tracking branch 'origin/3.0.x'

Conflicts:
	liquibase-core/src/main/java/liquibase/parser/core/xml/XMLChangeLogSAXHandler.java

FilePath: liquibase-core/src/main/java/liquibase/parser/core/xml/XMLChangeLogSAXHandler.java**
```diff
 							}
-							fileUrl = new File(zipFileDir, pathName).toURL();
+                            URI fileUri = new File(zipFileDir, pathName).toURI();
+							fileUrl = fileUri.toURL();
```
ProjectName: 8859-javassist
CommitID: 243bceef5ab08307d8136a3c40b70f9fc6661100
CommitMsg: fixed deprecated API calls

git-svn-id: http://anonsvn.jboss.org/repos/javassist/trunk@526 30ef5769-5b8d-40dd-aea6-55b5d6557bb3

FilePath: src/main/javassist/ClassPoolTail.java**
```diff
             try {
-                return f.getCanonicalFile().toURL();
+                return f.getCanonicalFile().toURI().toURL();
```
ProjectName: 8859-javassist
CommitID: 243bceef5ab08307d8136a3c40b70f9fc6661100
CommitMsg: fixed deprecated API calls

git-svn-id: http://anonsvn.jboss.org/repos/javassist/trunk@526 30ef5769-5b8d-40dd-aea6-55b5d6557bb3

FilePath: src/main/javassist/ClassPoolTail.java**
```diff
             jarfileURL = new File(pathname).getCanonicalFile()
-                                           .toURL().toString();
+                                           .toURI().toURL().toString();
```
ProjectName: 13536-activemq
CommitID: b14fec37161f67e6fbf59405ed03333bbdc01e5b
CommitMsg: https://issues.apache.org/activemq/browse/AMQ-2869 - starting in a path with spaces

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@985198 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-console/src/main/java/org/apache/activemq/console/Main.java**
```diff
                     // dir.getCanonicalPath()); }catch(Exception e){}
-                    urls.add(dir.toURL());
+                    urls.add(dir.toURI().toURL());
```
ProjectName: 13536-activemq
CommitID: b14fec37161f67e6fbf59405ed03333bbdc01e5b
CommitMsg: https://issues.apache.org/activemq/browse/AMQ-2869 - starting in a path with spaces

git-svn-id: https://svn.apache.org/repos/asf/activemq/trunk@985198 13f79535-47bb-0310-9956-ffa450edef68

FilePath: activemq-console/src/main/java/org/apache/activemq/console/Main.java**
```diff
                                     // }catch(Exception e){}
-                                    urls.add(files[j].toURL());
+                                    urls.add(files[j].toURI().toURL());
```
ProjectName: 35532-cxf
CommitID: 0c6e8ccfbd241daa323283a554773ee2a66812a0
CommitMsg: Don't use some deprecated API's

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1414386 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/in_jvm_transport/src/main/java/demo/colocated/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 0c6e8ccfbd241daa323283a554773ee2a66812a0
CommitMsg: Don't use some deprecated API's

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1414386 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/ws_security/ut_policy/src/main/java/demo/wssec/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 0c6e8ccfbd241daa323283a554773ee2a66812a0
CommitMsg: Don't use some deprecated API's

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1414386 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/jaxws_dispatch_provider/src/main/java/demo/hwDispatch/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 0c6e8ccfbd241daa323283a554773ee2a66812a0
CommitMsg: Don't use some deprecated API's

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1414386 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/jaxws_handlers/src/main/java/demo/handlers/client/Client.java**
```diff
 
-        AddNumbersService service = new AddNumbersService(wsdl.toURL(), serviceName);
+        AddNumbersService service = new AddNumbersService(wsdl.toURI().toURL(), serviceName);
```
ProjectName: 35532-cxf
CommitID: ab41c7c6128d133aeca9d2ac9b6fed8817954c10
CommitMsg:  wsdl_first_xmlbeans in m2eclipse

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1406336 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/wsdl_first_xmlbeans/src/main/java/demo/hw/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: efe316ea0b84a59de5d48b920997fde8af777eea
CommitMsg: wsdl_first_xml_wrapped in m2eclipse

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1406335 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/wsdl_first_xml_wrapped/src/main/java/demo/hw/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 72d0a6fccb00376a236a2aba543113279f0f0cef
CommitMsg: wsdl_first_rpclit in m2eclipse

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1406331 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/wsdl_first_rpclit/src/main/java/demo/hwRPCLit/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 560f00dee8c5c712176ffc25dbe8a9669576582b
CommitMsg: wsdl_first_pure_xml in m2eclipse

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1406330 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/wsdl_first_pure_xml/src/main/java/demo/hw/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 0e589eb18461909ade02c8e67945699b8d93f829
CommitMsg: wsdl_first_https working better with m2eclipse

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1406329 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/wsdl_first_https/src/main/java/demo/hw_https/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 0e589eb18461909ade02c8e67945699b8d93f829
CommitMsg: wsdl_first_https working better with m2eclipse

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1406329 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/wsdl_first_https/src/main/java/demo/hw_https/client/ClientNonSpring.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 41ba6a119aa8361d3f41074cb258ddf9559b0b45
CommitMsg: Minor eclipse warning fix

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1310146 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/wsdl_first/src/main/java/com/example/customerservice/client/CustomerServiceClient.java**
```diff
             if (wsdlFile.exists()) {
-                wsdlURL = wsdlFile.toURL();
+                wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 35532-cxf
CommitID: 2a295436287bb53538f325f99d2baee85f8814e3
CommitMsg: Use non-deprecated API

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1227320 13f79535-47bb-0310-9956-ffa450edef68

FilePath: distribution/src/main/release/samples/js_browser_client_simple/src/main/java/demo/hw/client/Client.java**
```diff
         if (wsdlFile.exists()) {
-            wsdlURL = wsdlFile.toURL();
+            wsdlURL = wsdlFile.toURI().toURL();
```
ProjectName: 259-zxing
CommitID: 6c4fe1633f55d9298f42c41df583ee530d80723d
CommitMsg: Fixed a tiny deprecation warning

git-svn-id: https://zxing.googlecode.com/svn/trunk@413 59b500cc-1b3d-0410-9834-0bbf25fbcc57

FilePath: javase/src/com/google/zxing/client/j2se/GUIRunner.java**
```diff
     try {
-      imageIcon = new ImageIcon(file.toURL());
+      imageIcon = new ImageIcon(file.toURI().toURL());
```
