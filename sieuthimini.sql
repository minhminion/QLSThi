-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2019 at 03:25 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sieuthimini`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MAHD` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MASP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENSP` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `DONGIA` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitiethd`
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
-- Triggers `chitiethd`
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
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MAKH` char(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MANV` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYHD` datetime NOT NULL,
  `TONGTIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
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
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `HONV` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `TENKH` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `DIACHI` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE `loai` (
  `MALOAI` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENLOAI` char(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`MALOAI`, `TENLOAI`) VALUES
('001', 'Thức ăn'),
('002', 'Thức uống'),
('003', 'Đồ gia dụng');

-- --------------------------------------------------------

--
-- Table structure for table `loaigg`
--

CREATE TABLE `loaigg` (
  `MALOAIGG` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `PHANTRAMGG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MANCC` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENNCC` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `DIACHINCC` char(200) COLLATE utf8_unicode_ci NOT NULL,
  `DIENTHOAI` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `SOFAX` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MANCC`, `TENNCC`, `DIACHINCC`, `DIENTHOAI`, `SOFAX`) VALUES
('001', 'ABC', '268 Nguyễn Văn Linh TPHCM', '08399925', '0123456789'),
('002', 'VinGroup', '58 Tôn Thất Tùng Q7, TP.HCM', '093867278', '012345678');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `HONV` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `TENNV` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `NAMSINH` int(4) NOT NULL,
  `PHAI` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `MUCLUONG` float DEFAULT NULL,
  `DIACHI` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `IMG` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `HONV`, `TENNV`, `NAMSINH`, `PHAI`, `MUCLUONG`, `DIACHI`, `IMG`) VALUES
('001', 'Lưu Bảo', 'Minh', 1999, 'Nam', 5000000, '282 Nguyễn Tri Phương', '001.jpg'),
('002', 'Trần Văn', 'A', 1999, 'Nữ', 5000000, 'dasd', 'null'),
('003', 'Trần Thị', 'Thơ', 1996, 'Nữ', 5000000, 'adssd', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `nhasanxuat`
--

CREATE TABLE `nhasanxuat` (
  `MANSX` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENNSX` char(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhasanxuat`
--

INSERT INTO `nhasanxuat` (`MANSX`, `TENNSX`) VALUES
('001', 'Number 1'),
('002', 'Nabati'),
('003', 'CocaCola'),
('004', 'Pepsi'),
('005', 'Nestlé');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhaphang`
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
-- Dumping data for table `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`IDNHAP`, `MANCC`, `MASP`, `NGAYNHAP`, `DONGIANHAP`, `SOLUONG`, `TONGTIEN`) VALUES
('2', '001', '001', '2019-04-19 08:19:53.000000', 5000, 10, 50000);

--
-- Triggers `phieunhaphang`
--
DELIMITER $$
CREATE TRIGGER `ThemNhapHang` AFTER INSERT ON `phieunhaphang` FOR EACH ROW UPDATE sanpham SET SOLUONG = SOLUONG + NEW.SOLUONG WHERE MASP = NEW.MASP
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MASP` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `TENSP` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `GIA` int(11) DEFAULT NULL,
  `DONVITINH` char(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MALOAI` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `MANSX` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `IMG` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MASP`, `TENSP`, `SOLUONG`, `GIA`, `DONVITINH`, `MALOAI`, `MANSX`, `IMG`) VALUES
('001', 'CocaCola Light', 10, 8000, 'Lon', '002', '003', '001.jpg'),
('002', 'CocaCola', 20, 8000, 'Lon', '002', '003', '002.jpg'),
('003', 'KitKat Classic', 112, 10000, 'Gói', '001', '005', '003.jpg'),
('004', 'Nivea Man Deep White Oil Clear', 90, 27000, 'Tuýp', '003', '005', '004.jpg'),
('005', 'Lotte Xylitol hương Fresh Mint', 70, 25000, 'Hộp', '001', '001', '005.jpg'),
('006', 'Cà Phê Đen Birdy', 30, 8700, 'Lon', '002', '005', '006.jpg'),
('007', 'Nước Uống Đóng Chai Aquafina', 50, 9000, 'Chai', '002', '005', '007.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `thongtingiamgia`
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
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `enable` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `username`, `password`, `role`, `enable`) VALUES
('001', 'admin', 'admin', 'Admin', 1),
('002', 'sale', 'sale', 'Nhân Viên', 1),
('003', 'tho003', '123456', 'Nhân Viên', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MAHD`,`MASP`),
  ADD KEY `FK_CTHD` (`MASP`,`MAHD`) USING BTREE;

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`) USING BTREE,
  ADD KEY `FK_HD` (`MAKH`),
  ADD KEY `FK_HD_1` (`MANV`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Indexes for table `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MALOAI`);

--
-- Indexes for table `loaigg`
--
ALTER TABLE `loaigg`
  ADD PRIMARY KEY (`MALOAIGG`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MANCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);

--
-- Indexes for table `nhasanxuat`
--
ALTER TABLE `nhasanxuat`
  ADD PRIMARY KEY (`MANSX`);

--
-- Indexes for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`IDNHAP`),
  ADD KEY `FK_MANCC` (`MANCC`),
  ADD KEY `FK_SP` (`MASP`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASP`),
  ADD KEY `FK_SP` (`MALOAI`),
  ADD KEY `FK_SP_1` (`MANSX`);

--
-- Indexes for table `thongtingiamgia`
--
ALTER TABLE `thongtingiamgia`
  ADD PRIMARY KEY (`MALOAIGG`,`MASP`),
  ADD KEY `FK_TTGG_1` (`MASP`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `FK_ID` (`userID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `FK_CTHD` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`),
  ADD CONSTRAINT `FK_CTHD_1` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_HD` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`),
  ADD CONSTRAINT `FK_HD_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Constraints for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `phieunhaphang_ibfk_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`),
  ADD CONSTRAINT `phieunhaphang_ibfk_2` FOREIGN KEY (`MANCC`) REFERENCES `nhacungcap` (`MANCC`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `FK_SP` FOREIGN KEY (`MALOAI`) REFERENCES `loai` (`MALOAI`),
  ADD CONSTRAINT `FK_SP_1` FOREIGN KEY (`MANSX`) REFERENCES `nhasanxuat` (`MANSX`);

--
-- Constraints for table `thongtingiamgia`
--
ALTER TABLE `thongtingiamgia`
  ADD CONSTRAINT `FK_TTGG` FOREIGN KEY (`MALOAIGG`) REFERENCES `loaigg` (`MALOAIGG`),
  ADD CONSTRAINT `FK_TTGG_1` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `nhanvien` (`MANV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
