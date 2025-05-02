# Library Management System (Java OOP Project)

Sistem Manajemen Perpustakaan berbasis Java OOP dengan fitur pencarian buku berbasis Binary Search Tree, antrian peminjaman (Queue), riwayat pengembalian (Stack), dan manajemen user (Binary Tree). Sistem ini modular, interaktif, dan menggunakan struktur data yang sesuai dengan kasus nyatanya.

---

## Features

### 1. **Book Management**
- Tambah, Edit, Hapus, dan Lihat Daftar Buku
- Edit berdasarkan **judul**, bukan ID
- Dilengkapi dengan **konfirmasi boolean** sebelum mengubah judul, author, atau kategori
- ID buku dihasilkan otomatis

### 2. **Book Search**
- Pencarian buku berbasis **judul**
- Menggunakan **Binary Search Tree (BST)** untuk efisiensi
- Jika tidak ditemukan: tampilkan pesan `Tidak ada buku tersebut di list.`

### 3. **Borrowing Queue**
- Peminjaman berdasarkan **antrian (First Come First Serve)**
- Hanya bisa meminjam buku yang tersedia
- Buku yang sudah dipinjam tidak dapat dipinjam ulang

### 4. **Return History**
- Riwayat pengembalian menggunakan **Stack (LIFO)**
- Pengembalian hanya bisa dilakukan jika buku memang sedang dipinjam oleh user

### 5. **User Management**
- Manajemen user menggunakan **Binary Tree**
- Setiap user menyimpan daftar buku yang sedang dipinjam
- Tidak ada peminjaman ganda dari satu user untuk buku yang sama

---

## Project Structure

LibrarySystem/
│
├── models/
│ ├── Book.java # Representasi data buku
│ └── User.java # Representasi data user
│
├── system/
│ ├── BookManager.java # Manajemen buku
│ ├── SearchTree.java # Pencarian buku (BST)
│ ├── BorrowQueue.java # Antrian peminjaman (Queue)
│ ├── ReturnHistory.java # Riwayat pengembalian (Stack)
│ └── UserManager.java # Manajemen user (Binary Tree)
│
└── Main.java # Menu utama interaktif


---

## How to Run

1. **Compile** semua file:
   ```bash
   javac -d . Main.java models/*.java system/*.java
   java Main

   ===== LIBRARY MENU =====
1. Show All Books
2. Add Book
3. Edit Book
4. Delete Book
5. Search Book by Title
6. Add Borrow Request
7. Return Book
8. Show Return History
9. Show Users
0. Exit
Choose an option:

