###  infomation 
method del:
-java.util.Arrays.equals()
method add：
+java.security.MessageDigest.isEqual()
###  support count
project count : 5
commit count : 11
###  code
ProjectName: 12435-commafeed
CommitID: 62a8e8c119e6da84949b7543cbd8cee943d0b034
CommitMsg: prevent timing attacks by using a time-constant comparison algorithm

FilePath: src/main/java/com/commafeed/backend/service/PasswordEncryptionService.java**
```diff
 		// is equal to the stored hash
-		return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
+		return MessageDigest.isEqual(encryptedPassword, encryptedAttemptedPassword);
```
ProjectName: 14608-rapidoid
CommitID: 7d8872747514e02dce7f138d9ab38db367b12904
CommitMsg: Fixed timing attack vulnerability. Thanks to @syjer for discovering it.

FilePath: rapidoid-commons/src/main/java/org/netnix/AES.java**
```diff
 
-		if (Arrays.equals(hmac, expectedHmac)) {
+		if (MessageDigest.isEqual(hmac, expectedHmac)) {
```
ProjectName: 7829-shiro
CommitID: 7d6f53c5d73582660eac2e6f3194b5d1e910d5ce
CommitMsg: SHIRO-547 Use MessageDigest.isEqual when comparing digests

FilePath: crypto/hash/src/main/java/org/apache/shiro/crypto/hash/AbstractHash.java**
```diff
             Hash other = (Hash) o;
-            return Arrays.equals(getBytes(), other.getBytes());
+            return MessageDigest.isEqual(getBytes(), other.getBytes());
```
ProjectName: 7829-shiro
CommitID: 7d6f53c5d73582660eac2e6f3194b5d1e910d5ce
CommitMsg: SHIRO-547 Use MessageDigest.isEqual when comparing digests

FilePath: crypto/hash/src/main/java/org/apache/shiro/crypto/hash/SimpleHash.java**
```diff
             Hash other = (Hash) o;
-            return Arrays.equals(getBytes(), other.getBytes());
+            return MessageDigest.isEqual(getBytes(), other.getBytes());
```
ProjectName: 7829-shiro
CommitID: 7d6f53c5d73582660eac2e6f3194b5d1e910d5ce
CommitMsg: SHIRO-547 Use MessageDigest.isEqual when comparing digests

FilePath: core/src/main/java/org/apache/shiro/authc/credential/SimpleCredentialsMatcher.java**
```diff
             byte[] accountBytes = toBytes(accountCredentials);
-            return Arrays.equals(tokenBytes, accountBytes);
+            return MessageDigest.isEqual(tokenBytes, accountBytes);
```
ProjectName: 5921-cryptomator
CommitID: 8bfdad38b9a87b1c5dd9089205ad3fa4de2a2425
CommitMsg: - fixed timing attack on MAC (see http://codahale.com/a-lesson-in-timing-attacks/)

FilePath: main/crypto-aes/src/main/java/org/cryptomator/crypto/aes256/Aes256Cryptor.java**
```diff
 
-		// compare:
-		return Arrays.equals(macBuffer.array(), mac.doFinal());
+		// compare (in constant time):
+		return MessageDigest.isEqual(macBuffer.array(), mac.doFinal());
```
ProjectName: 35532-cxf
CommitID: c09877e9773d5a4b5737930a348ce9f13e48df42
CommitMsg: Use MessageDigest in the SCTCanceller

FilePath: services/sts/sts-core/src/main/java/org/apache/cxf/sts/token/canceller/SCTCanceller.java**
```diff
                     byte[] receivedKey = (byte[])engineResult.get(WSSecurityEngineResult.TAG_SECRET);
-                    if (Arrays.equals(secretToMatch, receivedKey)) {
+                    if (MessageDigest.isEqual(secretToMatch, receivedKey)) {
```
ProjectName: 35532-cxf
CommitID: c09877e9773d5a4b5737930a348ce9f13e48df42
CommitMsg: Use MessageDigest in the SCTCanceller

FilePath: services/sts/sts-core/src/main/java/org/apache/cxf/sts/token/canceller/SCTCanceller.java**
```diff
                             if (keyObject instanceof SecretKey
-                                && Arrays.equals(secretToMatch, ((SecretKey)keyObject).getEncoded())) {
+                                && MessageDigest.isEqual(secretToMatch, ((SecretKey)keyObject).getEncoded())) {
```
ProjectName: 35532-cxf
CommitID: e66ce235ee5f8dbde467c8c23eeb622b072d0bf3
CommitMsg: Doing a better bytes comparison in some of JAXRS OAuth2/Jose code

FilePath: rt/rs/security/jose-parent/jose/src/main/java/org/apache/cxf/rs/security/jose/jws/HmacJwsSignatureVerifier.java**
```diff
         byte[] expected = computeMac(headers, unsignedText);
-        return Arrays.equals(expected, signature);
+        return MessageDigest.isEqual(expected, signature);
```
ProjectName: 35532-cxf
CommitID: e66ce235ee5f8dbde467c8c23eeb622b072d0bf3
CommitMsg: Doing a better bytes comparison in some of JAXRS OAuth2/Jose code

FilePath: rt/rs/security/oauth-parent/oauth2/src/main/java/org/apache/cxf/rs/security/oauth2/tokens/hawk/AbstractHawkAccessTokenValidator.java**
```diff
             byte[] clientMacData = Base64Utility.decode(clientMacString);
-            boolean validMac = Arrays.equals(serverMacData, clientMacData);
+            boolean validMac = MessageDigest.isEqual(serverMacData, clientMacData);
```
ProjectName: 35532-cxf
CommitID: e66ce235ee5f8dbde467c8c23eeb622b072d0bf3
CommitMsg: Doing a better bytes comparison in some of JAXRS OAuth2/Jose code

FilePath: rt/rs/security/jose-parent/jose/src/main/java/org/apache/cxf/rs/security/jose/jwe/AesCbcHmacJweDecryption.java**
```diff
         byte[] expectedAuthTag = AesCbcHmacJweEncryption.signAndGetTag(macState);
-        if (!Arrays.equals(actualAuthTag, expectedAuthTag)) {
+        if (!MessageDigest.isEqual(actualAuthTag, expectedAuthTag)) {
```
