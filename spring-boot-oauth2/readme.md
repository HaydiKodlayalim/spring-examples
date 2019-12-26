
###Client Bilgileri
- client_id – Authorization yapilacak client id
- client_secret – ilgili client a ait özel bir kod (client sifresi)
- access_token_validity – client in hala geçerli olup olmadığını gösterir
- authorities – client a hangi rollere izin verildiğini belirtmek için
- scope – izin verilecek scope 
- authorized_grant_types, kullanıcıların belirli client a nasıl giriş yapabileceği (bizim örneğimizde parola ile bir form girişi)


```
create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);
```

```
INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('uygulama1', '$2a$10$yUPOeM1kXeA8YY/rIT0w6uLJjQnwompxQ0xG.9hsK6b27vAzaprn6', 'uygulama1,read,write','password,authorization_code,refresh_token', null, null, 36000, 36000, null, true)

```