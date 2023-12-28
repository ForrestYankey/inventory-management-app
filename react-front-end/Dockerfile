# Use the official Node.js image as base image
FROM node:14-alpine

# Set the working directory in the container
WORKDIR /inventory-management-app

# Copy the package.json and package-lock.json files
COPY package*.json ./

# Install app dependencies
RUN npm install --quiet   # Using --quiet to reduce log output

# Copy the remaining application files
COPY . .

# Build the React app
RUN npm run build

# Expose the port the app runs on
EXPOSE 3000

# Specify the command to run on container start
CMD ["npm", "start"]
