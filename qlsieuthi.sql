-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 25, 2019 lúc 03:43 AM
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
-- Cơ sở dữ liệu: `qlsieuthi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `idSP` varchar(10) NOT NULL,
  `idNSX` varchar(10) NOT NULL,
  `nameSP` varchar(100) NOT NULL,
  `loaiSP` varchar(50) NOT NULL,
  `dongiaSP` int(50) NOT NULL,
  `DVT` varchar(50) NOT NULL,
  `IMG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`idSP`, `idNSX`, `nameSP`, `loaiSP`, `dongiaSP`, `DVT`, `IMG`) VALUES
('001', '001', 'Keo deo Marshies', 'Thuc an', 12000, 'Goi', 'sp0.jpg'),
('002', '001', 'Snack Poca', 'Thuc an', 10000, 'Goi', 'sp1.jpg'),
('003', '001', 'Banh Bastogne', 'Thuc an', 15000, 'Hop', 'sp2.jpg'),
('004', '001', 'Chocopie Dark', 'Thuc an', 20000, 'Hop', 'sp3.jpg'),
('005', '001', 'KitKat Orginal', 'Thuc an', 25000, 'Goi', 'sp4.jpg'),
('006', '001', 'KitKat Match', 'Thuc an', 8000, 'Goi', 'sp5.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `userID` varchar(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(10) NOT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`userID`, `user`, `pass`, `enable`) VALUES
('ad1', 'admin', 'admin', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`idSP`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
