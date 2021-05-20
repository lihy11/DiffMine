###  infomation 
method del:
-java.util.logging.Logger.warning()
method add：
+java.util.logging.Logger.fine()
###  support count
project count : 4
commit count : 17
###  code
ProjectName: 25999-geotools
CommitID: fee9d9c006b049118efc8a89d6688bf713a97411
CommitMsg: GEOT-5522: App-schema warnings log too verbose
FilePath: modules/extension/complex/src/main/java/org/geotools/data/complex/filter/XPathUtil.java**
```diff
                 if (!localName.equals(rootName.getLocalPart())) {
-                    LOGGER.warning("Using root's namespace " + defaultNamespace
+                    LOGGER.fine("Using root's namespace " + defaultNamespace
```
ProjectName: 25999-geotools
CommitID: fee9d9c006b049118efc8a89d6688bf713a97411
CommitMsg: GEOT-5522: App-schema warnings log too verbose
FilePath: modules/extension/complex/src/main/java/org/geotools/data/complex/config/FeatureTypeRegistry.java**
```diff
         } else {
-            LOGGER.warning(assignedName + " has no super type");
+            LOGGER.fine(assignedName + " has no super type");
```
ProjectName: 25999-geotools
CommitID: 38c9fb95dab5fbfddedd7098f9861ea65bf45531
CommitMsg: tone down commong xml binding warnings

XML is not quite as exact as one would expect and the code has been set up to be more relaxed about bindings ... and issue a warning when doing so.

This s change downgradess these common binding warnings to level fine (reducing the logs during our unit tests).

FilePath: modules/extension/xsd/xsd-gml2/src/main/java/org/geotools/gml2/bindings/GML2ParsingUtils.java**
```diff
                 // could not find a binding, use the defaults
-                LOGGER.warning( "Could not find binding for " + property.getQName() + ", using XSAnyTypeBinding." );
+                LOGGER.fine( "Could not find binding for " + property.getQName() + ", using XSAnyTypeBinding." );
```
ProjectName: 25999-geotools
CommitID: 38c9fb95dab5fbfddedd7098f9861ea65bf45531
CommitMsg: tone down commong xml binding warnings

XML is not quite as exact as one would expect and the code has been set up to be more relaxed about bindings ... and issue a warning when doing so.

This s change downgradess these common binding warnings to level fine (reducing the logs during our unit tests).

FilePath: modules/extension/xsd/xsd-core/src/main/java/org/geotools/xml/impl/AttributeEncodeExecutor.java**
```diff
         if (binding.getType() == null) {
-            logger.warning("Binding: " + binding.getTarget() + " does not declare a target type");
+            logger.fine("Binding: " + binding.getTarget() + " does not declare a target type");
```
ProjectName: 25999-geotools
CommitID: 38c9fb95dab5fbfddedd7098f9861ea65bf45531
CommitMsg: tone down commong xml binding warnings

XML is not quite as exact as one would expect and the code has been set up to be more relaxed about bindings ... and issue a warning when doing so.

This s change downgradess these common binding warnings to level fine (reducing the logs during our unit tests).

FilePath: modules/extension/xsd/xsd-core/src/main/java/org/geotools/xml/impl/AttributeEncodeExecutor.java**
```diff
             } else {
-                logger.warning(object + "[ " + object.getClass() + " ] is not of type "
+                logger.fine(object + "[ " + object.getClass() + " ] is not of type "
```
ProjectName: 25999-geotools
CommitID: c93c9063a01766dd4d202b9201b040b84d9a16d5
CommitMsg: Tone down null CRS from warning to fine

This was done to help new geotools developers, however the result fills up our test case logs.

FilePath: modules/library/main/src/main/java/org/geotools/feature/simple/SimpleFeatureTypeBuilder.java**
```diff
                 if( defaultCrs == null && !defaultCrsSet){
-                    LOGGER.warning("Creating "+name+" with null CoordinateReferenceSystem - did you mean to setCRS?");
+                    LOGGER.fine("Creating "+name+" with null CoordinateReferenceSystem - did you mean to setCRS?");
```
ProjectName: 25999-geotools
CommitID: 2e7db4df7b25290e5e3b72e6a372e43c42acfd09
CommitMsg: Toning down logging level for axis order found in wkt definition

FilePath: modules/library/referencing/src/main/java/org/geotools/referencing/factory/PropertyAuthorityFactory.java**
```diff
             if (s.containsAxis((String) wkt)) {
-                LOGGER.warning("Axis elements found in a wkt definition, the force longitude " +
+                LOGGER.fine("Axis elements found in a wkt definition, the force longitude " +
```
ProjectName: 25999-geotools
CommitID: ae62951cd797af68edf126c346547b849ea9d322
CommitMsg: decreasing log level from warning to info for case of encoding feature type when none can be found in schema

git-svn-id: http://svn.osgeo.org/geotools/trunk@38664 e5c1c795-43da-0310-a71f-fac65c449510

FilePath: modules/extension/xsd/xsd-gml2/src/main/java/org/geotools/gml2/bindings/GMLEncodingUtils.java**
```diff
                 // could not find the feature type in the schema, create a mock one
-                LOGGER.warning("Could find type for " + typeName
+                LOGGER.fine("Could find type for " + typeName
```
ProjectName: 25999-geotools
CommitID: da30bb65a50af52c7687f347926eff377fb100c9
CommitMsg: reducing log level when parsing features without a known feature type

git-svn-id: http://svn.osgeo.org/geotools/trunk@37784 e5c1c795-43da-0310-a71f-fac65c449510

FilePath: modules/extension/xsd/xsd-gml2/src/main/java/org/geotools/gml2/bindings/GMLEncodingUtils.java**
```diff
                 // could not find the feature type in the schema, create a mock one
-                LOGGER.warning("Could find type for " + typeName
+                LOGGER.fine("Could find type for " + typeName
```
ProjectName: 8346-pmd
CommitID: 0b52f6427a4880306ea462dca48877e43d6d45c7
CommitMsg: Add regression test for MissingOverride

Refs #2007

FilePath: pmd-java/src/main/java/net/sourceforge/pmd/lang/java/rule/bestpractices/MissingOverrideRule.java**
```diff
             // the parent class.
-            LOG.warning("MissingOverride encountered unexpected method " + node.getMethodName());
+            LOG.fine("MissingOverride encountered unexpected method " + node.getMethodName());
```
ProjectName: 15769-calcite
CommitID: f1df07f6f132c4dea7177642dd24f6eb71a7ea11
CommitMsg: Fix https://github.com/julianhyde/optiq/issues/163, "Equi-join warning".

FilePath: core/src/main/java/net/hydromatic/optiq/rules/java/JavaRules.java**
```diff
       } catch (InvalidRelException e) {
-        LOGGER.warning(e.toString());
+        LOGGER.fine(e.toString());
```
ProjectName: 15769-calcite
CommitID: f1df07f6f132c4dea7177642dd24f6eb71a7ea11
CommitMsg: Fix https://github.com/julianhyde/optiq/issues/163, "Equi-join warning".

FilePath: core/src/main/java/net/hydromatic/optiq/rules/java/JavaRules.java**
```diff
       } catch (InvalidRelException e) {
-        LOGGER.warning(e.toString());
+        LOGGER.fine(e.toString());
```
ProjectName: 15769-calcite
CommitID: f1df07f6f132c4dea7177642dd24f6eb71a7ea11
CommitMsg: Fix https://github.com/julianhyde/optiq/issues/163, "Equi-join warning".

FilePath: core/src/main/java/net/hydromatic/optiq/impl/jdbc/JdbcRules.java**
```diff
       } catch (InvalidRelException e) {
-        LOGGER.warning(e.toString());
+        LOGGER.fine(e.toString());
```
ProjectName: 15769-calcite
CommitID: f1df07f6f132c4dea7177642dd24f6eb71a7ea11
CommitMsg: Fix https://github.com/julianhyde/optiq/issues/163, "Equi-join warning".

FilePath: core/src/main/java/net/hydromatic/optiq/impl/jdbc/JdbcRules.java**
```diff
       } catch (InvalidRelException e) {
-        LOGGER.warning(e.toString());
+        LOGGER.fine(e.toString());
```
ProjectName: 35532-cxf
CommitID: 59a1524546d6c9767b69897f30c119fe81446885
CommitMsg: Downgrade loglevel for regular requests

Every request, even if successful, results in many warning entries, alerting developer unnecessarily. This modification downgrades log level to "fine", like in "checkHttpVerb" method. So, regular and authorized requests do not increase log file with WARNS.

This closes #2

Signed-off-by: Daniel Kulp <dkulp@apache.org>

FilePath: rt/rs/security/oauth-parent/oauth2/src/main/java/org/apache/cxf/rs/security/oauth2/filters/OAuthRequestFilter.java**
```diff
             String message = "Invalid request URI: " + request.getRequestURL().toString();
-            LOG.warning(message);
+            LOG.fine(message);
```
ProjectName: 35532-cxf
CommitID: 3a89665775890e7482a99d7c29dff448da224167
CommitMsg: Change NamePasswordCallbackHandler logging level to fine from warning when looking at method arguments

git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@1481892 13f79535-47bb-0310-9956-ffa450edef68

FilePath: rt/core/src/main/java/org/apache/cxf/interceptor/security/NamePasswordCallbackHandler.java**
```diff
                 // ignore and continue
-                LOG.warning(e.toString());
+                LOG.fine(e.toString());
```
ProjectName: 35532-cxf
CommitID: 2543785c4a6906dfb7d38852653ee7fbce5acc91
CommitMsg: Fix the rest of CXF-2126.


git-svn-id: https://svn.apache.org/repos/asf/cxf/trunk@756986 13f79535-47bb-0310-9956-ffa450edef68

FilePath: common/xerces-xsd-validation/src/main/java/org/apache/cxf/xsdvalidation/DOMLSInput.java**
```diff
         data = writer.toString();
-        LOG.warning(systemId + ": " + data);
+        LOG.fine(systemId + ": " + data);
```
