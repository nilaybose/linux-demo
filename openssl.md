echo -n "hello" | openssl aes-128-ecb  -e -K a863740c2d269f628c678f8298261929 | xxd -p

echo -n "6495f3ac36095eabcb4169d08b266c96" | xxd -p -r | openssl aes-128-ecb -d -K a863740c2d269f628c678f8298261929
