-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 04, 2019 lúc 03:10 PM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

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
  `TENSP` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `DONGIA` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`MAHD`, `MASP`, `TENSP`, `SOLUONG`, `DONGIA`) VALUES
('001', '002', 'CocaCola', 10, 8000),
('002', '002', 'CocaCola', 10, 8000),
('002', '005', 'Lotte Xylitol hương Fresh Mint', 20, 25000),
('003', '001', 'CocaCola Light', 10, 8000),
('003', '002', 'CocaCola', 10, 8000),
('003', '003', 'KitKat Classic', 1, 10000),
('004', '001', 'CocaCola Light', 3, 8000),
('004', '002', 'CocaCola', 1, 8000),
('004', '003', 'KitKat Classic', 1, 10000),
('004', '004', 'Nivea Man Deep White Oil Clear', 1, 27000),
('004', '005', 'Lotte Xylitol hương Fresh Mint', 3, 25000),
('007', '002', 'CocaCola', 12, 8000),
('007', '003', 'KitKat Classic', 4, 10000),
('008', '001', 'CocaCola Light', 7, 8000),
('008', '002', 'CocaCola', 4, 8000),
('008', '003', 'KitKat Classic', 8, 10000),
('008', '004', 'Nivea Man Deep White Oil Clear', 5, 27000),
('008', '005', 'Lotte Xylitol hương Fresh Mint', 8, 25000),
('008', '006', 'Cà Phê Đen Birdy', 1, 8700),
('008', '007', 'Nước Uống Đóng Chai Aquafina', 3, 9000);

--
-- Bẫy `chitiethd`
--
DELIMITER $$
CREATE TRIGGER `Them_ChiTiet` AFTER INSERT ON `chitiethd` FOR EACH ROW UPDATE `sanpham`
SET SOLUONG = SOLUONG - NEW.SOLUONG
WHERE MASP = NEW.MASP
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `Xoa_ChiTiet` AFTER DELETE ON `chitiethd` FOR EACH ROW BEGIN
 	UPDATE `sanpham`
	SET SOLUONG = SOLUONG + OLD.SOLUONG
	WHERE `sanpham`.`MASP` = OLD.MASP;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MAKH` char(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MANV` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYHD` datetime NOT NULL,
  `TONGTIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MAHD`, `MAKH`, `MANV`, `NGAYHD`, `TONGTIEN`) VALUES
('001', NULL, '001', '2019-01-01 00:00:00', 10000),
('002', NULL, '001', '2019-11-30 10:25:50', 80000),
('003', NULL, '001', '2019-03-12 17:09:24', 170000),
('004', NULL, '002', '2019-03-11 19:04:40', 144000),
('006', NULL, '001', '2019-01-15 17:18:39', 48000),
('007', NULL, '001', '2019-02-13 18:23:12', 136000),
('008', NULL, '002', '2019-04-15 18:24:23', 538700);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `HOKH` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `TENKH` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `DIACHI` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` int(11) NOT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MAKH`, `HOKH`, `TENKH`, `DIACHI`, `SDT`, `enable`) VALUES
('001', 'Trần Văn', 'dasd', 'da', 212132, 1);

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
  `TENNCC` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `DIACHINCC` char(200) COLLATE utf8_unicode_ci NOT NULL,
  `DIENTHOAI` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `SOFAX` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MANCC`, `TENNCC`, `DIACHINCC`, `DIENTHOAI`, `SOFAX`, `enable`) VALUES
('001', 'ABC', '268 Nguyễn Văn Linh TPHCM', '08399925', '0123456789', 1),
('002', 'VinGroup', '58 Tôn Thất Tùng Q7, TP.HCM', '093867278', '012345678', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `HONV` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `TENNV` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `NAMSINH` int(4) NOT NULL,
  `PHAI` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `MUCLUONG` float DEFAULT NULL,
  `DIACHI` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `IMG` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `HONV`, `TENNV`, `NAMSINH`, `PHAI`, `MUCLUONG`, `DIACHI`, `IMG`, `enable`) VALUES
('001', 'Lưu Bảo', 'Minh', 1999, 'Nam', 5000000, '282 Nguyễn Tri Phương', '001.jpg', 1),
('002', 'Trần Văn', 'A', 1999, 'Nữ', 5000000, 'dasd', 'null', 1),
('003', 'Trần Thị', 'Thơ', 1996, 'Nữ', 5000000, 'adssd', 'null', 1);

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
  `IDNHAP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MANCC` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MASP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYNHAP` datetime(6) NOT NULL,
  `DONGIANHAP` int(11) NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `TONGTIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`IDNHAP`, `MANCC`, `MASP`, `NGAYNHAP`, `DONGIANHAP`, `SOLUONG`, `TONGTIEN`) VALUES
('2', '001', '001', '2019-04-19 08:19:53.000000', 5000, 10, 50000);

--
-- Bẫy `phieunhaphang`
--
DELIMITER $$
CREATE TRIGGER `ThemNhapHang` AFTER INSERT ON `phieunhaphang` FOR EACH ROW UPDATE sanpham SET SOLUONG = SOLUONG + NEW.SOLUONG WHERE MASP = NEW.MASP
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MASP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENSP` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `GIA` int(11) DEFAULT NULL,
  `DONVITINH` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MALOAI` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MANSX` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `IMG` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MASP`, `TENSP`, `SOLUONG`, `GIA`, `DONVITINH`, `MALOAI`, `MANSX`, `IMG`, `enable`) VALUES
('001', 'CocaCola Light', 10, 8000, 'Lon', '002', '003', '001.jpg', 1),
('002', 'CocaCola', 20, 8000, 'Lon', '002', '003', '002.jpg', 1),
('003', 'KitKat Classic', 500, 10000, 'Gói', '001', '005', '003.jpg', 1),
('004', 'Nivea Man Deep White Oil Clear', 90, 27000, 'Tuýp', '003', '005', '004.jpg', 1),
('005', 'Lotte Xylitol hương Fresh Mint', 70, 25000, 'Hộp', '001', '001', '005.jpg', 1),
('006', 'Cà Phê Đen Birdy', 30, 8700, 'Lon', '002', '005', '006.jpg', 1),
('007', 'Nước Uống Đóng Chai Aquafina', 60, 9000, 'Chai', '002', '005', '007.jpg', 1);

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
  `userID` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `enable` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`userID`, `username`, `password`, `role`, `enable`) VALUES
('001', 'admin', 'admin', 'Admin', 1),
('002', 'sale', 'sale', 'Nhân Viên', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MAHD`,`MASP`),
  ADD KEY `FK_CTHD` (`MASP`,`MAHD`) USING BTREE;

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`) USING BTREE,
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
  ADD PRIMARY KEY (`IDNHAP`),
  ADD KEY `FK_MANCC` (`MANCC`),
  ADD KEY `FK_SP` (`MASP`);

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
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `FK_ID` (`userID`);

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
  ADD CONSTRAINT `phieunhaphang_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`),
  ADD CONSTRAINT `phieunhaphang_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`);

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

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `nhanvien` (`MANV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
