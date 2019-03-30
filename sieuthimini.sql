-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 29, 2019 lúc 04:15 PM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Cơ sở dữ liệu: `sieuthimini`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MAHD` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MASP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `DONGIA` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MAKH` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MANV` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYHD` datetime NOT NULL,
  `TONGTIEN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `HONV` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `TENLOT` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `TENKH` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `DIACHI` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `MALOAI` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENLOAI` char(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`MALOAI`, `TENLOAI`) VALUES
('001', 'Thức ăn'),
('002', 'Thức uống'),
('003', 'Đồ gia dụng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaigg`
--

CREATE TABLE `loaigg` (
  `MALOAIGG` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `PHANTRAMGG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MANCC` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENNCC` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYCC` datetime NOT NULL,
  `DIACHINCC` char(6) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `HONV` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `TENLOT` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `TENNV` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `NAMSINH` datetime NOT NULL,
  `PHAI` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `MUCLUONG` float DEFAULT NULL,
  `DIACHI` char(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhasanxuat`
--

CREATE TABLE `nhasanxuat` (
  `MANSX` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENNSX` char(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhasanxuat`
--

INSERT INTO `nhasanxuat` (`MANSX`, `TENNSX`) VALUES
('001', 'Number 1'),
('002', 'Nabati'),
('003', 'CocaCola'),
('004', 'Pepsi'),
('005', 'Nestlé');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `MANCC` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MASP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYNHAP` datetime DEFAULT NULL,
  `DONGIANHAP` int(11) DEFAULT NULL,
  `TONGTIEN` int(11) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MASP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENSP` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `GIA` int(11) DEFAULT NULL,
  `DONVITINH` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MALOAI` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MANSX` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `IMG` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MASP`, `TENSP`, `SOLUONG`, `GIA`, `DONVITINH`, `MALOAI`, `MANSX`, `IMG`) VALUES
('001', 'CocaCola Light', 100, 8000, 'Lon', '002', '003', '001.jpg'),
('002', 'CocaCola', 100, 8000, 'Lon', '002', '003', '002.jpg'),
('003', 'Socola KitKat', 30, 5000, 'Gói', '001', '005', '003.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtingiamgia`
--

CREATE TABLE `thongtingiamgia` (
  `MALOAIGG` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MASP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `DOTGG` datetime NOT NULL,
  `BATDAU` datetime NOT NULL,
  `KETTHUC` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `enable` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MAHD`,`MASP`),
  ADD KEY `FK_CTHD` (`MASP`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`,`MAKH`,`MANV`),
  ADD KEY `FK_HD` (`MAKH`),
  ADD KEY `FK_HD_1` (`MANV`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MALOAI`);

--
-- Chỉ mục cho bảng `loaigg`
--
ALTER TABLE `loaigg`
  ADD PRIMARY KEY (`MALOAIGG`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MANCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);

--
-- Chỉ mục cho bảng `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  ADD PRIMARY KEY (`MANSX`);

--
-- Chỉ mục cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`MANCC`,`MASP`),
  ADD KEY `FK_PHN_1` (`MASP`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASP`),
  ADD KEY `FK_SP` (`MALOAI`),
  ADD KEY `FK_SP_1` (`MANSX`);

--
-- Chỉ mục cho bảng `thongtingiamgia`
--
ALTER TABLE `thongtingiamgia`
  ADD PRIMARY KEY (`MALOAIGG`,`MASP`),
  ADD KEY `FK_TTGG_1` (`MASP`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `FK_CTHD` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`),
  ADD CONSTRAINT `FK_CTHD_1` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_HD` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`),
  ADD CONSTRAINT `FK_HD_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `FK_PHN` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`),
  ADD CONSTRAINT `FK_PHN_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `FK_SP` FOREIGN KEY (`MALOAI`) REFERENCES `loai` (`MALOAI`),
  ADD CONSTRAINT `FK_SP_1` FOREIGN KEY (`MANSX`) REFERENCES `nhasanxuat` (`MANSX`);

--
-- Các ràng buộc cho bảng `thongtingiamgia`
--
ALTER TABLE `thongtingiamgia`
  ADD CONSTRAINT `FK_TTGG` FOREIGN KEY (`MALOAIGG`) REFERENCES `loaigg` (`MALOAIGG`),
  ADD CONSTRAINT `FK_TTGG_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
