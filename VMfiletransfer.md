# File Transfer Between Virtual Machines

## AIM
To transfer files from one virtual machine to another.

## PROCEDURE

1. **Open VMware** and log in to your Ubuntu virtual machine.
  
2. **Right-click** on **Ubuntu 64-bit** in VMware Workstation and select **Settings**.

3. In the **Virtual Machine Settings** window, click on the **Options** tab.

4. Under **Options**, select **Shared Folders** and choose the **Always enabled** option.

5. Click **Add**, then **Next** in the **Add Shared Folder Wizard**.

6. Click **Browse** and select the folder to share, then click **Next**.

7. Enable the share by checking **Enable this share**, and click **Finish**.

8. Click **OK** to close the Virtual Machine Settings.

9. **Log in** to your Ubuntu user and open the terminal.

10. Type the command to check shared files:
    ```bash
    vmware-hgfsclient
    ```
    You should see `Linux_shared_files`.

11. Open the directory:
    ```bash
    cd /mnt/hgfs/Linux_shared_files/
    ```

12. **Create a new folder** named `hadoop`:
    ```bash
    mkdir hadoop
    ```

13. Verify the folder creation:
    ```bash
    ls
    ```

14. **Move the `Hadoop_1` file** to the `hadoop` folder:
    ```bash
    mv Hadoop_1 hadoop/
    ```

15. **Copy the contents** of the `h1` file to a new file:
    ```bash
    cp h1 hadoop_commands.txt
    ```

16. Verify the files:
    ```bash
    ls
    ```

## RESULT
The implementation of file transfer between virtual machines has been executed successfully.
