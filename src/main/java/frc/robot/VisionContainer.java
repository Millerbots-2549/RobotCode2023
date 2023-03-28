// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Optional;

import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import frc.robot.Constants.VisionConstants;

/** Add your docs here. */
public final class VisionContainer {

    private final PhotonCamera camera = new PhotonCamera(VisionConstants.kCameraName);
    private AprilTagFieldLayout fieldLayout = VisionConstants.kFieldLayout;

    private final PhotonPoseEstimator poseEstimator = new PhotonPoseEstimator(
        fieldLayout, PoseStrategy.AVERAGE_BEST_TARGETS, camera, VisionConstants.kRobotToCamTransform);

    public Optional<EstimatedRobotPose> getEstimatedRobotPose() {
        return poseEstimator.update();
    }
    
    UsbCamera intakecam = CameraServer.startAutomaticCapture();
    
    public VisionContainer() {
        intakecam.setResolution(640, 480);
    }
}
