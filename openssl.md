echo -n "hello" | openssl aes-128-ecb  -e -K a863740c2d269f628c678f8298261929 | xxd -p

echo -n "6495f3ac36095eabcb4169d08b266c96" | xxd -p -r | openssl aes-128-ecb -d -K a863740c2d269f628c678f8298261929

openssl pkcs12 -in S0023615091.pfx -clcerts -out S0023615091.pem
openssl pkcs12 -in S0023615091.pfx -nokeys -out S0023615091.crt
openssl rsa -in S0023615091.pem -out S0023615091.key


