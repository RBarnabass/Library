function generateHashWithSalt(password, serverSalt) {

    const clientSalt = [...Array(16)].map(_ => (~~(Math.random() * 36)).toString(36)).join('');

    const hashedPasswordBits = sjcl.hash.sha256.hash(password);
    const passwordHash = sjcl.codec.hex.fromBits(hashedPasswordBits);

    const saltedPasswordHash = passwordHash + serverSalt + clientSalt;

    const hashedSaltedPasswordHashBits = sjcl.hash.sha256.hash(saltedPasswordHash);
    const finalHash = sjcl.codec.hex.fromBits(hashedSaltedPasswordHashBits);

    return {
        "hash": finalHash,
        "clientSalt": clientSalt,
    }
}