# Panduan Penggunaan Aplikasi

Panduan ini memberikan instruksi langkah demi langkah untuk menggunakan aplikasi, termasuk login, navigasi menu, dan manajemen barang.

---

## Prasyarat

1. Pastikan Anda telah menginstal dan mengonfigurasi **JavaFX** di lingkungan pengembangan Anda.
2. Pastikan semua gambar yang digunakan dalam aplikasi berada di jalur file yang sesuai.
3. Kompilasi dan jalankan aplikasi menggunakan Java 8 atau versi yang lebih baru.

---

## Gambaran Fitur

1. **Sistem Login**
    - Login Pengguna
    - Login Admin
2. **Navigasi Menu**
    - Menu Pengguna (Pembelian Barang)
    - Menu Admin
3. **Manajemen Barang**
    - Pembelian Barang
    - Pengembalian Barang

---

## Menjalankan Aplikasi

### Langkah 1: Jalankan Aplikasi

Jalankan file utama untuk menjalankan aplikasi:

```bash
java -cp . tugasbesar.LoginPasien
```

Layar login akan muncul.

---

### Langkah 2: Login sebagai Pengguna

1. Masukkan email dan kata sandi Anda di formulir login.
    - Contoh kredensial:
        - Email: `rumahsakit@gmail.com`
        - Kata Sandi: `12345`
2. Klik tombol **Login** untuk melanjutkan.
3. Jika kredensial benar, **Menu Pengguna** akan muncul.

#### Alternatif: Login sebagai Admin

1. Klik **Login Admin** untuk beralih ke formulir login admin.
2. Masukkan kredensial admin Anda:
    - Email: `rumahsakit@gmail.com`
    - Kata Sandi: `12345`
3. Klik **Login** untuk melanjutkan ke **Menu Admin**.

---

### Langkah 3: Navigasi Menu Pengguna

#### Pembelian Barang

1. Di **Menu Pengguna**, klik **Beli Barang**.
2. Telusuri barang yang tersedia di tabel.
3. Masukkan nomor barang di bidang input.
4. Klik **OK** untuk mengonfirmasi pembelian.
5. Jika barang tersedia, jumlahnya akan berkurang.

#### Pengembalian Barang

1. Di **Menu Pengguna**, pilih **Pengembalian Barang**.
2. Lihat barang yang dipinjam di tabel.
3. Masukkan nomor barang untuk dikembalikan.
4. Klik **OK** untuk mengonfirmasi pengembalian.

---

### Langkah 4: Logout

1. Dari menu mana saja, klik **Keluar** untuk keluar dan kembali ke layar login.

---

## Catatan

1. Pastikan semua jalur file gambar dan koneksi database dikonfigurasi dengan benar.
2. Pesan kesalahan akan muncul jika input yang diberikan tidak benar.
    - Contoh: Kolom email atau kata sandi kosong.

Untuk detail lebih lanjut tentang kustomisasi kode atau pemecahan masalah, lihat file sumber atau hubungi tim pengembang.
