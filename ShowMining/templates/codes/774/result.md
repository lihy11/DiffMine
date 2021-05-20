###  infomation 
method del:
-null.split()
method add：
+java.lang.String.split()
###  support count
project count : 11
commit count : 12
###  code
ProjectName: 53780-alf.io
CommitID: 80bd1394d94f7a62f8d62db3f9191dd19da62b9e
CommitMsg: prevent NPE

FilePath: src/main/java/alfio/util/PasswordGenerator.java**
```diff
         PASSWORD_CHARACTERS = ArrayUtils.toPrimitive(chars.toArray(new Character[chars.size()]));
-        DEV_MODE = Arrays.stream(StringUtils.split(System.getProperty("spring.profiles.active"), ','))
+        DEV_MODE = Arrays.stream(Optional.ofNullable(System.getProperty("spring.profiles.active")).map(p -> p.split(",")).orElse(new String[0]))
```
ProjectName: 46970-xJavaFxTool
CommitID: ae72569cddef53b417f7e2fe8f0d6da11dc12539
CommitMsg: 更新readme

FilePath: src/main/java/com/xwintop/xJavaFxTool/utils/XJavaFxSystemUtil.java**
```diff
             PropertiesConfiguration xmlConfigure = new PropertiesConfiguration(file);
-            String[] locale1 = xmlConfigure.getString("Locale").split("_");
-            if (locale1 != null) {
+            String localeString = xmlConfigure.getString("Locale");
+            if (StringUtils.isNotEmpty(localeString)) {
+                String[] locale1 = localeString.split("_");
```
ProjectName: 33064-xodus
CommitID: 277d18e395f373fabea4e16865226522fbd7845e
CommitMsg: fix API

FilePath: entity-store/src/main/java/jetbrains/exodus/entitystore/iterate/EntityIterableBase.java**
```diff
     public static String getHumanReadablePresentation(@NotNull final EntityIterableHandle handle) {
-        String[] types = handle.toString().split("-");
+        return getHumanReadablePresentation(handle.toString());
+    }
+
+    public static String getHumanReadablePresentation(@NotNull final String handle) {
+        String[] types = handle.split("-");
```
ProjectName: 36169-takes
CommitID: 33631a86f7fe646b0e326b2b233b45efb7ac376b
CommitMsg: #166 remove StringUtils.split method call

FilePath: src/main/java/org/takes/facets/hamcrest/RsMatchStatus.java**
```diff
             final String head = item.head().iterator().next();
-            final String[] headParts = StringUtils.split(head, HEAD_SEPARATOR);
+            final String[] headParts = head.split(HEAD_SEPARATOR);
```
ProjectName: 24467-lenskit
CommitID: 760fb1d8a387a64ee2eef64ceea1f44c40436d6e
CommitMsg: Drop plexus-utils

FilePath: lenskit-core/src/main/java/org/grouplens/lenskit/util/spi/ServiceFinder.java**
```diff
             Class<?> cls = svc.getClass();
-            String[] nameParts = StringUtils.split(cls.getName(), ".");
+            String[] nameParts = cls.getName().split("\\.");
```
ProjectName: 29579-Payara
CommitID: 80a9541aa1b6b1ff4a8acf06ae8d501de3813d39
CommitMsg: Add a null check in case of the list-instances's value return the null

git-svn-id: https://svn.java.net/svn/glassfish~svn/trunk/main@62714 6f3ba3e3-413c-0410-a8aa-90bee3ab43b5

FilePath: nucleus/cluster/cli/src/main/java/com/sun/enterprise/admin/cli/cluster/CreateLocalInstanceCommand.java**
```diff
         RemoteCLICommand rc = new RemoteCLICommand("list-instances", this.programOpts, this.env);
-        String[] registeredInstanceNamesOnThisNode =
-                rc.executeAndReturnOutput("list-instances", "--nostatus", _node).split("\r?\n");
+        String returnOutput =
+                rc.executeAndReturnOutput("list-instances", "--nostatus", _node);
+        if (returnOutput == null)
+            return;
+        String[] registeredInstanceNamesOnThisNode = returnOutput.split("\r?\n");
```
ProjectName: 10256-traccar
CommitID: 849878cf105baed2348c605f7232012efb294480
CommitMsg: Add genx format setter

FilePath: src/org/traccar/protocol/GenxProtocolDecoder.java**
```diff
         super(protocol);
-        String[] columns = Context.getConfig().getString(getProtocolName() + ".reportColumns", "1,2,3,4").split(",");
+        setReportColumns(Context.getConfig().getString(getProtocolName() + ".reportColumns", "1,2,3,4"));
+    }
+
+    public void setReportColumns(String format) {
+        String[] columns = format.split(",");
```
ProjectName: 10572-Openfire
CommitID: 496dfb3f42baf7a21f98b81feea33a29b321b810
CommitMsg: Fixes possible NPE while loading the properties.


git-svn-id: http://svn.igniterealtime.org/svn/repos/messenger/trunk@119 b35dd754-fafc-0310-a699-88a17e54d16e

FilePath: src/java/org/jivesoftware/messenger/muc/spi/MultiUserChatServerImpl.java**
```diff
         // Load the list of JIDs that are sysadmins of the MUC service
-        String[] jids = JiveGlobals.getProperty("xmpp.muc.sysadmin.jid").split(",");
+        String property = JiveGlobals.getProperty("xmpp.muc.sysadmin.jid");
+        String[] jids = (property != null ? property.split(",") : new String[]{""});
```
ProjectName: 10572-Openfire
CommitID: 496dfb3f42baf7a21f98b81feea33a29b321b810
CommitMsg: Fixes possible NPE while loading the properties.


git-svn-id: http://svn.igniterealtime.org/svn/repos/messenger/trunk@119 b35dd754-fafc-0310-a699-88a17e54d16e

FilePath: src/java/org/jivesoftware/messenger/muc/spi/MultiUserChatServerImpl.java**
```diff
         // Load the list of JIDs that are allowed to create a MUC room
-        jids = JiveGlobals.getProperty("xmpp.muc.create.jid").split(",");
+        property = JiveGlobals.getProperty("xmpp.muc.create.jid");
+        jids = (property != null ? property.split(",") : new String[]{""});
```
ProjectName: 2688-swagger-core
CommitID: ae0c22904fbe25d14255f3c330c71a95567c2cc0
CommitMsg: complete removal of guava dependency from main code base

FilePath: modules/swagger-jaxrs2/src/main/java/io/swagger/v3/jaxrs2/util/ReaderUtils.java**
```diff
         for (String string : strings) {
-            Iterables.addAll(result, Splitter.on(",").trimResults().omitEmptyStrings().split(string));
+            for (String split : string.split("\\s*,\\s*")) {
+                if (!split.isEmpty()) result.add(split);
+            }
```
ProjectName: 5607-atmosphere
CommitID: 452c679ac10979a4c362123c07a3eabba601635a
CommitMsg: Print the version

FilePath: modules/cpr/src/main/java/org/atmosphere/interceptor/JavaScriptProtocol.java**
```diff
 
-            int version = Integer.valueOf(request.getHeader(HeaderConfig.X_ATMOSPHERE_FRAMEWORK).split("-")[0].replace(".", ""));
+            String javascriptVersion = request.getHeader(HeaderConfig.X_ATMOSPHERE_FRAMEWORK);
+            int version = Integer.valueOf(javascriptVersion.split("-")[0].replace(".", ""));
```
ProjectName: 8048-ForkHub
CommitID: f12fe8e03c5a95c4c6f20e3ebb43399bf3aefa11
CommitMsg: Show a link to the root folder in the code browser

Closes #191

FilePath: app/src/main/java/com/github/mobile/ui/code/RepositoryCodeFragment.java**
```diff
             int textLightColor = getResources().getColor(R.color.text_light);
-            final String[] segments = folder.entry.getPath().split("/");
+            final String fullPath = repository.getName() + "/" + folder.entry.getPath();
+            final String[] segments = fullPath.split("/");
```
