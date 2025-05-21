#!/bin/bash

set -e

# Config
GRADLE_VERSION=8.4
DIST_URL="https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
ZIP_FILE="gradle-${GRADLE_VERSION}-bin.zip"
UNZIP_DIR="gradle-${GRADLE_VERSION}"

echo "📦 Downloading Gradle ${GRADLE_VERSION}..."
curl -L $DIST_URL -o $ZIP_FILE

echo "📂 Unzipping..."
unzip -q $ZIP_FILE -d $UNZIP_DIR

echo "🔁 Replacing Gradle wrapper files..."

# Create wrapper dir if it doesn't exist
mkdir -p gradle/wrapper

# Copy gradlew scripts
cp "$UNZIP_DIR/gradle-${GRADLE_VERSION}/bin/gradle" ./gradlew
chmod +x ./gradlew

# Copy wrapper jar and update properties
cp "$UNZIP_DIR/gradle-${GRADLE_VERSION}/lib/plugins/gradle-wrapper-${GRADLE_VERSION}.jar" gradle/wrapper/gradle-wrapper.jar

# Create or overwrite gradle-wrapper.properties
cat > gradle/wrapper/gradle-wrapper.properties <<EOF
distributionUrl=https\://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip
EOF

echo "✅ Gradle wrapper upgraded to ${GRADLE_VERSION}"

# Clean up
rm -rf "$ZIP_FILE" "$UNZIP_DIR"
