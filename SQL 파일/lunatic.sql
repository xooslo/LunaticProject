-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- 생성 시간: 21-11-15 17:41
-- 서버 버전: 10.4.19-MariaDB
-- PHP 버전: 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `lunatic`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `log_info`
--

CREATE TABLE `log_info` (
  `id` varchar(30) NOT NULL,
  `nick` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `log_info`
--

INSERT INTO `log_info` (`id`, `nick`) VALUES
('haesun', '1234');

-- --------------------------------------------------------

--
-- 테이블 구조 `player`
--

CREATE TABLE `player` (
  `id` varchar(30) NOT NULL,
  `nick` varchar(10) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `player`
--

INSERT INTO `player` (`id`, `nick`, `password`) VALUES
('fullsun', '??????', '1234'),
('haesun', 'hae', '1234'),
('xooslo', '현재여친', '1234');

-- --------------------------------------------------------

--
-- 테이블 구조 `save`
--

CREATE TABLE `save` (
  `id` int(11) NOT NULL,
  `stage` int(3) NOT NULL,
  `potion` varchar(10) NOT NULL,
  `accessory` varchar(10) NOT NULL,
  `skin` varchar(10) NOT NULL,
  `weapon` varchar(10) NOT NULL,
  `player_id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `save`
--

INSERT INTO `save` (`id`, `stage`, `potion`, `accessory`, `skin`, `weapon`, `player_id`) VALUES
(1, 2, 'p001', 'a001', 's001', 'w001', 'xooslo'),
(2, 1, 'p001', 'a001', 's001', 'w001', 'haesun');

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `log_info`
--
ALTER TABLE `log_info`
  ADD PRIMARY KEY (`id`);

--
-- 테이블의 인덱스 `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`);

--
-- 테이블의 인덱스 `save`
--
ALTER TABLE `save`
  ADD PRIMARY KEY (`id`),
  ADD KEY `player_id` (`player_id`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `save`
--
ALTER TABLE `save`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 덤프된 테이블의 제약사항
--

--
-- 테이블의 제약사항 `log_info`
--
ALTER TABLE `log_info`
  ADD CONSTRAINT `session_id` FOREIGN KEY (`id`) REFERENCES `player` (`id`);

--
-- 테이블의 제약사항 `save`
--
ALTER TABLE `save`
  ADD CONSTRAINT `player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
