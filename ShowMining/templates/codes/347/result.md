###  infomation 
method del:
-null.getConfigurationLegacy()
method add：
+null.getConfiguration()
###  support count
project count : 1
commit count : 14
###  code
ProjectName: 40863-isis
CommitID: 5516b5543d0f370f5fb3d206c6d38b6aa318bb39
CommitMsg: ISIS-2086: refactors 'isis.viewer.wicket.breadcrumbs.showChooser' to type-safe config

FilePath: core/viewer-wicket/ui/src/main/java/org/apache/isis/viewer/wicket/ui/components/widgets/breadcrumbs/BreadcrumbPanel.java**
```diff
 
-        boolean shouldShow = getConfigurationLegacy().getBoolean(SHOW_BREADCRUMBS_KEY, SHOW_BREADCRUMBS_DEFAULT);
+        boolean shouldShow = getConfiguration().getViewer().getWicket().getBreadcrumbs().isShowChooser();
```
ProjectName: 40863-isis
CommitID: 5516b5543d0f370f5fb3d206c6d38b6aa318bb39
CommitMsg: ISIS-2086: refactors 'isis.viewer.wicket.breadcrumbs.showChooser' to type-safe config

FilePath: core/viewer-wicket/ui/src/main/java/org/apache/isis/viewer/wicket/ui/components/footer/FooterPanel.java**
```diff
 
-        boolean showBreadcrumbs = getConfigurationLegacy().getBoolean(
-                BreadcrumbPanel.SHOW_BREADCRUMBS_KEY, BreadcrumbPanel.SHOW_BREADCRUMBS_DEFAULT);
+        boolean showBreadcrumbs = getConfiguration().getViewer().getWicket().getBreadcrumbs().isShowChooser();
```
ProjectName: 40863-isis
CommitID: 5516b5543d0f370f5fb3d206c6d38b6aa318bb39
CommitMsg: ISIS-2086: refactors 'isis.viewer.wicket.breadcrumbs.showChooser' to type-safe config

FilePath: core/viewer-wicket/ui/src/main/java/org/apache/isis/viewer/wicket/ui/pages/PageAbstract.java**
```diff
     protected boolean isShowBreadcrumbs() {
-        return getConfigurationLegacy() .getBoolean(
-                BreadcrumbPanel.SHOW_BREADCRUMBS_KEY, BreadcrumbPanel.SHOW_BREADCRUMBS_DEFAULT);
+        return getConfiguration().getViewer().getWicket().getBreadcrumbs().isShowChooser();
```
ProjectName: 40863-isis
CommitID: 4edb04e398013e367c7fa8c0803c8e5d2b505f30
CommitMsg: ISIS-2086: converts 'isis.persistor.datanucleus.standaloneCollection.bulkLoad' to type-safe config

FilePath: core/viewer-wicket/model/src/main/java/org/apache/isis/viewer/wicket/model/models/EntityCollectionModel.java**
```diff
 
-                //XXX lombok issue, cannot use val here 
-                boolean isBulkLoad = IsisContext.getConfigurationLegacy().getBoolean(KEY_BULK_LOAD, false);
+                val isBulkLoad = IsisContext.getConfiguration().getPersistor().getDatanucleus().getStandaloneCollection().isBulkLoad();
```
ProjectName: 40863-isis
CommitID: b5e437b0eeb2f8681721f10e46186a197409b0d9
CommitMsg: ISIS-2086: refactors 'isis.viewer.restfulobjects.honorUiHints' to type-safe config

FilePath: core/viewer-restfulobjects/server/src/main/java/org/apache/isis/viewer/restfulobjects/server/ResourceContext.java**
```diff
     public boolean honorUiHints() {
-        return getConfigurationLegacy().getBoolean("isis.viewer.restfulobjects.honorUiHints", HONOR_UI_HINTS_DEFAULT);
+        return getConfiguration().getViewer().getRestfulobjects().isHonorUiHints();
```
ProjectName: 40863-isis
CommitID: 29eecd1ca00a98512f5deb7c1c0f3c84711b2dcf
CommitMsg: ISIS-2086: refactors "isis.viewer.restfulobjects.gsoc2013.legacyParamDetails" to type-safe config

FilePath: core/viewer-restfulobjects/rendering/src/main/java/org/apache/isis/viewer/restfulobjects/rendering/domainobjects/ObjectActionReprRenderer.java**
```diff
     private ObjectActionReprRenderer addParameterDetails() {
-        boolean gsoc2013 = getRendererContext().getConfigurationLegacy().getBoolean("isis.viewer.restfulobjects.gsoc2013.legacyParamDetails", false);
+        boolean gsoc2013 = getRendererContext().getConfiguration().getViewer().getRestfulobjects().getGsoc2013().isLegacyParamDetails();
```
ProjectName: 40863-isis
CommitID: 6e398f45f3d802076ca694b453733566061b4480
CommitMsg: ISIS-2086: refactors 'isis.reflector.facets.filterForVisibility' completely to type-safe config

FilePath: core/metamodel/src/main/java/org/apache/isis/metamodel/facets/actions/action/invocation/ActionInvocationFacetForDomainEventAbstract.java**
```diff
 
-        final boolean filterForVisibility = getConfigurationLegacy().getBoolean("isis.reflector.facet.filterVisibility", true);
+        final boolean filterForVisibility = getConfiguration().getReflector().getFacet().isFilterVisibility();
```
ProjectName: 40863-isis
CommitID: 2defb1ae41e6f2ec9b12e61ab8354eac0fa0b52f
CommitMsg: ISIS-2086: refactors 'isis.reflector.validator.noParamsOnly' to type-safe config

FilePath: core/metamodel/src/main/java/org/apache/isis/metamodel/facets/members/disabled/method/DisableForContextFacetViaMethodFactory.java**
```diff
 
-        boolean noParamsOnly = getConfigurationLegacy().getBoolean(
-                ISIS_REFLECTOR_VALIDATOR_NO_PARAMS_ONLY_KEY,
-                ISIS_REFLECTOR_VALIDATOR_NO_PARAMS_ONLY_DEFAULT);
+        boolean noParamsOnly = getConfiguration().getReflector().getValidator().isNoParamsOnly();
```
ProjectName: 40863-isis
CommitID: 2defb1ae41e6f2ec9b12e61ab8354eac0fa0b52f
CommitMsg: ISIS-2086: refactors 'isis.reflector.validator.noParamsOnly' to type-safe config

FilePath: core/metamodel/src/main/java/org/apache/isis/metamodel/facets/members/hidden/method/HideForContextFacetViaMethodFactory.java**
```diff
 
-            boolean noParamsOnly = getConfigurationLegacy().getBoolean(
-                    ISIS_REFLECTOR_VALIDATOR_NO_PARAMS_ONLY_KEY,
-                    ISIS_REFLECTOR_VALIDATOR_NO_PARAMS_ONLY_DEFAULT);
+            boolean noParamsOnly = getConfiguration().getReflector().getValidator().isNoParamsOnly();
```
ProjectName: 40863-isis
CommitID: b2c29d1142013d8239dbf15cff086676ca468a0b
CommitMsg: ISIS-2086: refactors 'isis.reflector.validator.checkModuleExtent' as type-safe config

(cherry picked from commit 3ed5456381700c8b973c831248cece7290a33dc8)

FilePath: core/metamodel/src/main/java/org/apache/isis/metamodel/specloader/validator/MetaModelValidatorToCheckModuleExtent.java**
```diff
     public void validate(final ValidationFailures validationFailures) {
-        boolean check = getConfigurationLegacy()
-                .getBoolean(ISIS_REFLECTOR_CHECK_MODULE_EXTENT_KEY,
-                        ISIS_REFLECTOR_CHECK_MODULE_EXTENT_DEFAULT);
+        boolean check = getConfiguration().getReflector().getValidator().isCheckModuleExtent();
```
ProjectName: 40863-isis
CommitID: 1c3007d26813042434601a7d71a67cd183d65046
CommitMsg: ISIS-2086: refactors isis.viewer.wicket.maxTitleLengthInTables (and 2 related) to type-safe config

FilePath: core/viewer-wicket/impl/src/main/java/org/apache/isis/viewer/wicket/viewer/settings/WicketViewerSettingsDefault.java**
```diff
     public int getMaxTitleLengthInStandaloneTables() {
-        return getConfigurationLegacy().getInteger("isis.viewer.wicket.maxTitleLengthInStandaloneTables", getMaxTitleLengthInTables());
+        return getConfiguration().getViewer().getWicket().getMaxTitleLengthInStandaloneTables();
```
ProjectName: 40863-isis
CommitID: 1c3007d26813042434601a7d71a67cd183d65046
CommitMsg: ISIS-2086: refactors isis.viewer.wicket.maxTitleLengthInTables (and 2 related) to type-safe config

FilePath: core/viewer-wicket/impl/src/main/java/org/apache/isis/viewer/wicket/viewer/settings/WicketViewerSettingsDefault.java**
```diff
     public int getMaxTitleLengthInParentedTables() {
-        return getConfigurationLegacy().getInteger("isis.viewer.wicket.maxTitleLengthInParentedTables", getMaxTitleLengthInTables());
+        return getConfiguration().getViewer().getWicket().getMaxTitleLengthInParentedTables();
```
ProjectName: 40863-isis
CommitID: 1c3007d26813042434601a7d71a67cd183d65046
CommitMsg: ISIS-2086: refactors isis.viewer.wicket.maxTitleLengthInTables (and 2 related) to type-safe config

FilePath: core/viewer-wicket/impl/src/main/java/org/apache/isis/viewer/wicket/viewer/settings/WicketViewerSettingsDefault.java**
```diff
     private int getMaxTitleLengthInTables() {
-        return getConfigurationLegacy().getInteger("isis.viewer.wicket.maxTitleLengthInTables", 12);
+        return getConfiguration().getViewer().getWicket().getMaxTitleLengthInTables();
```
ProjectName: 40863-isis
CommitID: c9e74d3ffc26d738c439a2cc463f72e7a86dd673
CommitMsg: ISIS-2086: converts 'isis.reflector.validator.ensureUniqueObjectTypes' to type-safe config

FilePath: core/metamodel/src/main/java/org/apache/isis/metamodel/specloader/validator/MetaModelValidatorToCheckObjectSpecIdsUnique.java**
```diff
     public void validate(final ValidationFailures validationFailures) {
-        boolean check = getConfigurationLegacy()
-                .getBoolean(ISIS_REFLECTOR_ENSURE_UNIQUE_OBJECT_IDS_KEY,
-                        ISIS_REFLECTOR_ENSURE_UNIQUE_OBJECT_IDS_DEFAULT);
+        boolean check = getConfiguration().getReflector().getValidator().isEnsureUniqueObjectTypes();
```
