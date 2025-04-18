# 🧠 Object Detection Using DBScan Algorithm in Java

This project implements object detection using the **DBScan clustering algorithm** in Java, with two approaches to nearest neighbor search:

- **Linear Method**
- **KD-Tree Method**

It allows comparison between performance and output of both methods on multiple 3D point cloud datasets.

---

## 📂 Project Structure

### 📁 1. Java Source Code

#### 🔹 Common Files
- `DBScan.java` – Main DBScan algorithm
- `Point3D.java` – 3D point representation

#### 🔹 Linear Search Implementation
- `NearestNeighbors.java`

#### 🔹 KD-Tree Implementation
- `KDtree.java`
- `NearestNeighborsKD.java`

#### 🔹 Experiment Files
- `Exp1.java` – Complete implementation for experience 1
- `Exp2.java` – Complete implementation for experience 2
- `Exp3.java` – Complete implementation for experience 3

---

## 📊 Test Data

### 🧪 Provided Input Files
- `Point_Cloud_1.csv`
- `Point_Cloud_2.csv`
- `Point_Cloud_3.csv`

### 📁 Linear Method Outputs
- `Point_Cloud_1.csv_clusters_0.8_12_36.csv`
- `Point_Cloud_2.csv_clusters_0.8_12_35.csv`
- `Point_Cloud_3.csv_clusters_0.8_12_45.csv`

### 📁 KD-Tree Method Outputs
- `pt1_kd.txt`, `pt1_lin.txt`
- `pt2_kd.txt`, `pt2_lin.txt`
- ...
- `pt6_kd.txt`, `pt6_lin.txt`

---

## 📄 Reports

- `Experience 3.pdf`
- `CSI_Projet_partie_II_Report.pdf`

---

## ⚙️ Parameters Used

- `eps = 0.8`
- `minPts = 12`

---

## 📈 Visualization

You can use the included **Python scripts** to visualize the clustering results from both linear and KD-Tree methods.

---

> ✅ This project demonstrates efficient object detection through clustering in 3D space, and highlights performance trade-offs between brute-force and tree-based neighbor search.
