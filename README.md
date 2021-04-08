# Команды keytool
* Создание сертификата (пароль юзать лучше changeit, имя - localhost)  
`keytool -genkeypair -alias localhost -keyalg RSA -keysize 2048 -keystore anton.jks -validity 3650`
* Генерация файла сертификата (.crt)  
`keytool -exportcert -keystore anton.jks -alias [alias] -file [cert_file]`
* Импорт в кейстор  
`keytool -importkeystore -srckeystore anton.jks -destkeystore keystore.jks`
* Импорт в трастстор (паяра)  
`keytool -importcert -trustcacerts -destkeystore cacerts.jks -file danaserver.crt -alias danaserver`
# Ports
## wildfly
    admin 8690
    httplistener2 7143
## payara
    admin 6748
    httplistener2 6781

# Startup
## Service1 (Wildfly)
    ssh -L 7143:localhost:7143 s225123@helios.cs.ifmo.ru -p 2222  
    cd jboss/bin  
    ./standalone.sh  
## Service2 (Payara)
    ssh -L 6781:localhost:6781 s225123@helios.cs.ifmo.ru -p 2222  
    cd payara5/bin  
    ./asadmin start-domain domain1  
# `View`
## To  view both `Lab2` and `Lab3`
ssh -L 7143:localhost:7143 -L 6781:localhost:6781 s225123@helios.cs.ifmo.ru -p 2222  