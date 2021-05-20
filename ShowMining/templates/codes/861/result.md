###  infomation 
method del:
-java.lang.Class.equals()
method add：
+java.lang.Class.isAssignableFrom()
###  support count
project count : 10
commit count : 17
###  code
ProjectName: 32449-habitica-android
CommitID: 010541af5364d04ba043c13ab4cda4b61f794230
CommitMsg: fix tag editing

FilePath: Habitica/src/main/java/com/habitrpg/android/habitica/models/Tag.java**
```diff
     public boolean equals(Object o) {
-        if (o.getClass().equals(Tag.class)) {
+        if (Tag.class.isAssignableFrom(o.getClass())) {
```
ProjectName: 32104-spring-data-rest
CommitID: 0b5726ac414976112469c82bdd60b481419203ff
CommitMsg: DATAREST-385 - Projection definition configurations are now detected for super types.

Projections defined for a parent type are now also available for sub-types.
FilePath: spring-data-rest-core/src/main/java/org/springframework/data/rest/core/config/ProjectionDefinitionConfiguration.java**
```diff
 		for (ProjectionDefinitionKey key : projectionDefinitions.keySet()) {
-			if (key.sourceType.equals(sourceType)) {
+			if (key.sourceType.isAssignableFrom(sourceType)) {
```
ProjectName: 32104-spring-data-rest
CommitID: 0b5726ac414976112469c82bdd60b481419203ff
CommitMsg: DATAREST-385 - Projection definition configurations are now detected for super types.

Projections defined for a parent type are now also available for sub-types.
FilePath: spring-data-rest-core/src/main/java/org/springframework/data/rest/core/config/ProjectionDefinitionConfiguration.java**
```diff
 		for (Entry<ProjectionDefinitionKey, Class<?>> entry : projectionDefinitions.entrySet()) {
-			if (entry.getKey().sourceType.equals(sourceType)) {
+			if (entry.getKey().sourceType.isAssignableFrom(sourceType)) {
```
ProjectName: 34894-elide
CommitID: 0a6f02513672e2b39e96cb699476b9064b63a0d3
CommitMsg: Add support for matching inherited types. (#437)


FilePath: elide-core/src/main/java/com/yahoo/elide/core/PersistentResource.java**
```diff
                 inverseResource.delFromCollection((Collection) inverseRelation, inverseRelationName, this, true);
-            } else if (inverseRelationType.equals(this.getResourceClass())) {
+            } else if (inverseRelationType.isAssignableFrom(this.getResourceClass())) {
```
ProjectName: 34894-elide
CommitID: 0a6f02513672e2b39e96cb699476b9064b63a0d3
CommitMsg: Add support for matching inherited types. (#437)


FilePath: elide-core/src/main/java/com/yahoo/elide/core/PersistentResource.java**
```diff
                 }
-            } else if (inverseRelationType.equals(this.getResourceClass())) {
+            } else if (inverseRelationType.isAssignableFrom(this.getResourceClass())) {
```
ProjectName: 12801-pac4j
CommitID: 8ec7dacfd82a298ff7c349ce88a1ee1282fd4f16
CommitMsg: Merge pull request #57 from miremond/pac4j-13

refactor resource loading
FilePath: pac4j-core/src/main/java/org/pac4j/core/client/Clients.java**
```diff
         init();
-        for (final Client client : this.clients) {
-            if (client.getClass().equals(clazz)) {
+        if (clazz != null) {
+          for (final Client client : this.clients) {
+            if (clazz.isAssignableFrom(client.getClass())) {
```
ProjectName: 12801-pac4j
CommitID: 66b4777dc6f3e9e3973b158e55ee8be0e06a0df7
CommitMsg: Allow to subclass Client

Allow to subclass a client like FormClient, but get the client as it with :
Clients.findClient(FormClient.class);
FilePath: pac4j-core/src/main/java/org/pac4j/core/client/Clients.java**
```diff
         init();
-        for (final Client client : this.clients) {
-            if (client.getClass().equals(clazz)) {
+        if (clazz != null) {
+          for (final Client client : this.clients) {
+            if (clazz.isAssignableFrom(client.getClass())) {
```
ProjectName: 13026-spring-data-jpa
CommitID: 0d6376d6d87603ce6584da8b8b6cc671693bc5d1
CommitMsg: DATAJPA-1005 - Improved lookup of EntityManagerFactory bean definitions for constructor injectability.

Our bean definition check for EntityManagerFactory instances previously expected the type prediction to return exactly EntityManagerFactory. That should theoretically always be the case as the component inspecting the beans is a BeanFactoryPostProcessor, i.e. running before any of the beans should have been instantiated.

If however an EntityManagerFactoryBean is already in creation and the EntityManagerFactory backing it is already available, the factory bean will return the concrete factory's type (see AbstractEntityManagerFactoryBean.getObjectType()) so that we have to accept subtypes of EntityManagerFactory in our selection process.

Related ticket: DATAJPA-1045.
FilePath: src/main/java/org/springframework/data/jpa/util/BeanDefinitionUtils.java**
```diff
 			}
-		} else if (!EntityManagerFactory.class.equals(beanFactory.getType(name))) {
+		} else if (beanFactory.getType(name) == null
+				|| !EntityManagerFactory.class.isAssignableFrom(beanFactory.getType(name))) {
```
ProjectName: 7409-powermock
CommitID: a13f445c686476b26550c634a5cf13d9ada58386
CommitMsg: Improved the getAllMethodsExcept(..) method

FilePath: core/src/main/java/org/powermock/Whitebox.java**
```diff
 						for (int i = 0; i < args.length; i++) {
-							if (args[i].equals(argumentTypes[i])) {
+							if (args[i].isAssignableFrom(getUnmockedType(argumentTypes[i]))) {
```
ProjectName: 4607-hibernate-orm
CommitID: c9d4305bf191bcc95ceb7c5a4d6db740c71629c0
CommitMsg: HHH-8505: Fixed todos

FilePath: hibernate-envers/src/main/java/org/hibernate/envers/internal/entities/mapper/ComponentPropertyMapper.java**
```diff
 		this.propertyData = propertyData;
-		//ŁŻ this could be done better
-		if ( Map.class.equals( componentClass ) ) {
+		//if class is a map it means that this is dynamic component
+		if ( Map.class.isAssignableFrom( componentClass ) ) {
```
ProjectName: 2454-cas
CommitID: 1abfeac96460e0f5905f97a896c64b9002db5f00
CommitMsg: Merge pull request #6 from frett/extendRegisteredService

Make it easier to create a new RegisteredService implementation
FilePath: cas-server-core/src/main/java/org/jasig/cas/services/web/support/RegisteredServiceValidator.java**
```diff
     public boolean supports(final Class clazz) {
-        return RegisteredServiceImpl.class.equals(clazz);
+        return RegisteredService.class.isAssignableFrom(clazz);
```
ProjectName: 2454-cas
CommitID: 55360b39100f9bd740f4f7b793af52366018f744
CommitMsg: Update the supports method to support any implementation

FilePath: cas-server-core/src/main/java/org/jasig/cas/services/web/support/RegisteredServiceValidator.java**
```diff
     public boolean supports(final Class clazz) {
-        return RegisteredServiceImpl.class.equals(clazz);
+        return RegisteredService.class.isAssignableFrom(clazz);
```
ProjectName: 7427-hive
CommitID: bff8d95e91f94770fb0ae4a96009e22d16d7ddfa
CommitMsg: HIVE-17414: HoS DPP + Vectorization generates invalid explain plan due to CombineEquivalentWorkResolver (Liyun Zhang, reviewed by Sahil Takiar and Li Rui)

FilePath: ql/src/java/org/apache/hadoop/hive/ql/exec/spark/SparkUtilities.java**
```diff
     }
-    if (clazz.equals(root.getClass())) {
+    if (clazz.isAssignableFrom(root.getClass())) {
```
ProjectName: 7427-hive
CommitID: f1aae85f197de09d4b86143f7f13d5aa21d2eb85
CommitMsg: Support Parquet StatsNoJobTask for Spark & Tez engine (Chao Sun, reviewed by Xuefu Zhang)

FilePath: ql/src/java/org/apache/hadoop/hive/ql/parse/spark/SparkProcessAnalyzeTable.java**
```diff
       boolean noScan = parseContext.getQueryProperties().isNoScanAnalyzeCommand();
-      if (inputFormat.equals(OrcInputFormat.class) && (noScan || partialScan)) {
-
+      if ((OrcInputFormat.class.isAssignableFrom(inputFormat) ||
+          MapredParquetInputFormat.class.isAssignableFrom(inputFormat)) && (noScan || partialScan)) {
```
ProjectName: 7427-hive
CommitID: f1aae85f197de09d4b86143f7f13d5aa21d2eb85
CommitMsg: Support Parquet StatsNoJobTask for Spark & Tez engine (Chao Sun, reviewed by Xuefu Zhang)

FilePath: ql/src/java/org/apache/hadoop/hive/ql/parse/ProcessAnalyzeTable.java**
```diff
       TezWork tezWork = context.currentTask.getWork();
-      if (inputFormat.equals(OrcInputFormat.class)) {
-        // For ORC, all the following statements are the same
+      if (OrcInputFormat.class.isAssignableFrom(inputFormat) ||
+          MapredParquetInputFormat.class.isAssignableFrom(inputFormat)) {
+        // For ORC & Parquet, all the following statements are the same
```
ProjectName: 7427-hive
CommitID: 54ff3f56d495e24352624de2655be69d433bd179
CommitMsg: HIVE-14858: Analyze command should support custom input formats (Chao Sun, reviewed by Xuefu Zhang and Prasanth Jayachandran)

FilePath: ql/src/java/org/apache/hadoop/hive/ql/optimizer/GenMRTableScan1.java**
```diff
           boolean noScan = parseCtx.getQueryProperties().isNoScanAnalyzeCommand();
-          if (inputFormat.equals(OrcInputFormat.class) ||
-                  inputFormat.equals(MapredParquetInputFormat.class)) {
+          if (OrcInputFormat.class.isAssignableFrom(inputFormat) ||
+                  MapredParquetInputFormat.class.isAssignableFrom(inputFormat)) {
```
ProjectName: 35532-cxf
CommitID: e43079ffba8263b4f4726d06a0371d5a630da68d
CommitMsg: [CXF-5230]:Message element is not generated for exception class which extends Exception

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1516735 13f79535-47bb-0310-9956-ffa450edef68

FilePath: rt/databinding/jaxb/src/main/java/org/apache/cxf/jaxb/JAXBSchemaInitializer.java**
```diff
         // Create element in xsd:sequence for Exception.class
-        if (cls.equals(Exception.class)) {
+        if (Exception.class.isAssignableFrom(cls)) {
```
