#!/bin/sh

rm -rf output
mkdir output

javac -cp .:libs/ojdbc6.jar src/com/main/*.java -d output

cp libs/* output/
cp -r META-INF output/
cd output

jar -cvmf META-INF/MANIFEST.MF dbping.jar com

mkdir -p ../target
mv *.jar ../target
rm -rf ../output
