/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100408
 Source Host           : localhost:3306
 Source Schema         : epuskesmas

 Target Server Type    : MySQL
 Target Server Version : 100408
 File Encoding         : 65001

 Date: 15/11/2019 12:56:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for _dokter
-- ----------------------------
DROP TABLE IF EXISTS `_dokter`;
CREATE TABLE `_dokter`  (
  `nip_dokter` int(11) NOT NULL,
  `dokter_nama` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dokter_alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dokter_jenkel` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `no_tlp` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dokter_sip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dokter_jenis` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`nip_dokter`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of _dokter
-- ----------------------------
BEGIN;
INSERT INTO `_dokter` VALUES (192929, 'dr. Lusi', 'Taman Asri', 'Perempuan', '0812091299', 'KSKS-029', 'LANSIA'), (198231231, 'dr. Aini', 'Pondok Aren', 'Perempuan', '0812432453', 'NHK-008', 'LANSIA');
COMMIT;

-- ----------------------------
-- Table structure for _obat
-- ----------------------------
DROP TABLE IF EXISTS `_obat`;
CREATE TABLE `_obat`  (
  `id_obat` int(11) NOT NULL,
  `obat_nama` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `obat_jenis` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `obat_kadaluarsa` date NULL DEFAULT NULL,
  `obat_harga` int(11) NULL DEFAULT NULL,
  `obat_produsen` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_obat`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of _obat
-- ----------------------------
BEGIN;
INSERT INTO `_obat` VALUES (1, 'Ultraflu', 'Sedang', '2019-11-13', 20000, 'kimiafarma');
COMMIT;

-- ----------------------------
-- Table structure for _pasien
-- ----------------------------
DROP TABLE IF EXISTS `_pasien`;
CREATE TABLE `_pasien`  (
  `id_pasien` int(11) NOT NULL,
  `pasien_nama` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pasien_alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pasien_tgllahir` date NULL DEFAULT NULL,
  `pasien_notlp` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pasien_jenkel` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pasien_agama` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_pasien`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of _pasien
-- ----------------------------
BEGIN;
INSERT INTO `_pasien` VALUES (1, 'Budi', 'Larangan', '2019-11-10', '0812912129', 'Laki-Laki', 'Islam');
COMMIT;

-- ----------------------------
-- Table structure for rekammedik
-- ----------------------------
DROP TABLE IF EXISTS `rekammedik`;
CREATE TABLE `rekammedik`  (
  `no_rekammedik` int(11) NOT NULL,
  `id_pasien` int(11) NOT NULL,
  `rm_diagnosa` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nip_dokter` int(11) NOT NULL,
  `id_obat` int(11) NOT NULL,
  PRIMARY KEY (`no_rekammedik`, `id_pasien`, `nip_dokter`, `id_obat`) USING BTREE,
  INDEX `fk__pasien_has__dokter__dokter1_idx`(`nip_dokter`, `no_rekammedik`) USING BTREE,
  INDEX `fk__pasien_has__dokter__pasien1_idx`(`id_pasien`) USING BTREE,
  INDEX `fk_diagnosa__obat1_idx`(`id_obat`) USING BTREE,
  CONSTRAINT `fk__pasien_has__dokter__dokter1` FOREIGN KEY (`nip_dokter`) REFERENCES `_dokter` (`nip_dokter`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk__pasien_has__dokter__pasien1` FOREIGN KEY (`id_pasien`) REFERENCES `_pasien` (`id_pasien`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_diagnosa__obat1` FOREIGN KEY (`id_obat`) REFERENCES `_obat` (`id_obat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of rekammedik
-- ----------------------------
BEGIN;
INSERT INTO `rekammedik` VALUES (15154, 1, 'Kepala nyeri', 198231231, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
