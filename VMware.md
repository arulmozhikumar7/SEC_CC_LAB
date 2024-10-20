
# Virtual Machine Setup and C Programming on Ubuntu

## Installing VMware Workstation on Windows 10/8/7

### Steps:
1. **Download VMware Workstation**:
   - Visit [www.vmware.com](https://www.vmware.com) and download the VMware Workstation installer.
   
2. **Run the Installer**:
   - Double-click the `VMware-workstation-full-16.1.2-17966106.exe` file to start the setup wizard.

3. **Accept License Agreement**:
   - Accept the license terms by checking the box and clicking **Next**.

4. **Choose Installation Path**:
   - Choose the default installation path (C: drive) or specify another location, then click **Next**.

5. **Select Additional Features**:
   - Select these options:
     - **Enhanced Keyboard Driver**
     - **Add VMware Workstation console tools to system PATH**
   - Click **Next**.

6. **User Experience Settings**:
   - (Optional) Select:
     - **Check for product updates on startup**
     - **Join the Customer Experience Improvement Program**
   - Click **Next**.

7. **Create Shortcuts**:
   - Choose whether to create shortcuts on the Desktop and Start Menu, then click **Next**.

8. **Install**:
   - Click **Install** to start the installation.

9. **Finish**:
   - After installation completes, click **Finish** and restart your computer when prompted.

10. **Enter License Key**:
    - After restarting, open VMware Workstation and enter the following license key:
      ```
      ZF3R0-FHED2-M80TY-8QYGC-NPKYF
      ```

11. **VMware Ready**:
    - VMware Workstation is now installed and ready to use.

---

## Installing Ubuntu on VMware

### Steps:
1. **Download Ubuntu ISO**:
   - Visit [Ubuntu's official website](http://www.ubuntu.com/download/ubuntu/download) to download the ISO file.

2. **Create a New Virtual Machine**:
   - Open VMware and click **Create a New Virtual Machine**. Choose **Custom (Advanced)** and click **Next**.

3. **Select ISO File**:
   - Choose **Installer disk image file (iso)** and browse to the downloaded Ubuntu ISO file, then click **Next**.

4. **User Setup**:
   - Enter the following:
     - **Full name**: `ubuntu`
     - **Username**: `ubuntu`
     - **Password**: `cse123`
   - Click **Next**.

5. **Choose Virtual Machine Location**:
   - Select the default or specify a different location to store the virtual machine files, then click **Next**.

6. **Memory Allocation**:
   - Set the memory to **8GB**, then click **Next**.

7. **Network Setup**:
   - Choose **Bridged Networking** for network configuration, then click **Next**.

8. **Virtual Disk Setup**:
   - **I/O Controller**: Select **LSI Logic**.
   - **Disk Type**: Choose **SCSI**.
   - **Create New Virtual Disk**: Select **Create a new virtual disk** and set the maximum disk size to **110GB**.
   - Choose **Split virtual disk into multiple files**, then click **Next**.

9. **Finish Setup**:
   - Click **Finish** to create and power on the virtual machine.

10. **Complete Ubuntu Installation**:
    - Follow the on-screen prompts to install Ubuntu, using the password `cse123`.
    - After installation, restart the virtual machine.

---

## Installing C Compiler and Running a C Program in Ubuntu

### Steps:

1. **Open Terminal**:
   - Go to **Applications > Accessories > Terminal**.

2. **Update the System**:
   ```bash
   sudo apt update
   sudo apt upgrade -y
   ```

3. **Install GCC (C Compiler)**:
   ```bash
   sudo apt install gcc
   ```

4. **Write a C Program**:
   ```bash
   gedit hello.c
   ```
   Write the following code:
   ```c
   #include <stdio.h>
   int main() {
       printf("Hello, World!\n");
       return 0;
   }
   ```
   Save and close the file.

5. **Compile the Program**:
   ```bash
   gcc hello.c
   ```

6. **Run the Program**:
   ```bash
   ./a.out
   ```
   The output will display: `Hello, World!`.

