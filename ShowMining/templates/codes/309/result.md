###  infomation 
method del:
-null.getBytes()
method add：
+null.getOctets()
###  support count
project count : 1
commit count : 12
###  code
ProjectName: 21291-bc-java
CommitID: 079961e4b90a0eb84dc236d4c868ccb1282eba4a
CommitMsg: Added use of getOctets()

FilePath: pkix/src/main/java/org/bouncycastle/cert/ocsp/BasicOCSPResp.java**
```diff
     {
-        return resp.getSignature().getBytes();
+        return resp.getSignature().getOctets();
```
ProjectName: 21291-bc-java
CommitID: 079961e4b90a0eb84dc236d4c868ccb1282eba4a
CommitMsg: Added use of getOctets()

FilePath: pkix/src/main/java/org/bouncycastle/cert/ocsp/OCSPReq.java**
```diff
 
-        return req.getOptionalSignature().getSignature().getBytes();
+        return req.getOptionalSignature().getSignature().getOctets();
```
ProjectName: 21291-bc-java
CommitID: c1ac66f829ac787cd2f54b593b713448f56b686a
CommitMsg: Added more getOctets()

FilePath: pkix/src/main/java/org/bouncycastle/cert/X509CertificateHolder.java**
```diff
     {
-        return x509Certificate.getSignature().getBytes();
+        return x509Certificate.getSignature().getOctets();
```
ProjectName: 21291-bc-java
CommitID: c1ac66f829ac787cd2f54b593b713448f56b686a
CommitMsg: Added more getOctets()

FilePath: pkix/src/main/java/org/bouncycastle/cert/X509AttributeCertificateHolder.java**
```diff
     {
-        return attrCert.getSignatureValue().getBytes();
+        return attrCert.getSignatureValue().getOctets();
```
ProjectName: 21291-bc-java
CommitID: c1ac66f829ac787cd2f54b593b713448f56b686a
CommitMsg: Added more getOctets()

FilePath: pkix/src/main/java/org/bouncycastle/cert/crmf/CertificateRequestMessage.java**
```diff
 
-        return verifier.verify(popoSign.getSignature().getBytes());
+        return verifier.verify(popoSign.getSignature().getOctets());
```
ProjectName: 21291-bc-java
CommitID: 7e566c0878c5871ea61a88a28987811d729dd4e5
CommitMsg: Added use of getOctets()

FilePath: pkix/src/main/java/org/bouncycastle/cert/X509CRLHolder.java**
```diff
 
-        return verifier.verify(x509CRL.getSignature().getBytes());
+        return verifier.verify(x509CRL.getSignature().getOctets());
```
ProjectName: 21291-bc-java
CommitID: 7e566c0878c5871ea61a88a28987811d729dd4e5
CommitMsg: Added use of getOctets()

FilePath: prov/src/main/java/org/bouncycastle/jcajce/provider/asymmetric/x509/X509CRLObject.java**
```diff
     {
-        return c.getSignature().getBytes();
+        return c.getSignature().getOctets();
```
ProjectName: 21291-bc-java
CommitID: 7e566c0878c5871ea61a88a28987811d729dd4e5
CommitMsg: Added use of getOctets()

FilePath: prov/src/main/java/org/bouncycastle/jce/provider/X509CRLObject.java**
```diff
     {
-        return c.getSignature().getBytes();
+        return c.getSignature().getOctets();
```
ProjectName: 21291-bc-java
CommitID: 107c0439128da7a84a6abac66f32702914ac7eff
CommitMsg: Added use of getOctets()

FilePath: pkix/src/main/java/org/bouncycastle/cert/X509AttributeCertificateHolder.java**
```diff
 
-        return verifier.verify(attrCert.getSignatureValue().getBytes());
+        return verifier.verify(attrCert.getSignatureValue().getOctets());
```
ProjectName: 21291-bc-java
CommitID: 107c0439128da7a84a6abac66f32702914ac7eff
CommitMsg: Added use of getOctets()

FilePath: pkix/src/main/java/org/bouncycastle/cert/X509CertificateHolder.java**
```diff
 
-        return verifier.verify(x509Certificate.getSignature().getBytes());
+        return verifier.verify(x509Certificate.getSignature().getOctets());
```
ProjectName: 21291-bc-java
CommitID: 855a62a7ab6e8f03eb691f7cfc2a1dd9487e9e75
CommitMsg: Added use of getOctets() to X509CertificateObject

FilePath: prov/src/main/java/org/bouncycastle/jcajce/provider/asymmetric/x509/X509CertificateObject.java**
```diff
     {
-        return c.getSignature().getBytes();
+        return c.getSignature().getOctets();
```
ProjectName: 21291-bc-java
CommitID: 855a62a7ab6e8f03eb691f7cfc2a1dd9487e9e75
CommitMsg: Added use of getOctets() to X509CertificateObject

FilePath: prov/src/main/java/org/bouncycastle/jce/provider/X509CertificateObject.java**
```diff
     {
-        return c.getSignature().getBytes();
+        return c.getSignature().getOctets();
```
