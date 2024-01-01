# Use the official Node.js image as base image
FROM node:14

# Set the working directory in the container
WORKDIR /app

# Copy the package.json and package-lock.json files
COPY package*.json ./

# Install app dependencies
RUN npm install

# Copy the remaining application files
COPY . .

# Build the React app
RUN npm run build

ENV PORT=8080

# Expose the port the app runs on
EXPOSE 8080

# Specify the command to run on container start
CMD ["npm", "start"]