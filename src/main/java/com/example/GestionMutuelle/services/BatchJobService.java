package com.example.GestionMutuelle.services;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
public class BatchJobService {

    private final JobLauncher jobLauncher;
    private final Job job;

    public BatchJobService(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    // Méthode pour exécuter le job
    public String runJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            // Démarrer le job avec des paramètres (si nécessaire)
            JobExecution jobExecution = jobLauncher.run(job, jobParameters);
            return "Le job a démarré avec succès. Statut : " + jobExecution.getStatus();
        } catch (JobExecutionException e) {
            e.printStackTrace();
            return "Erreur lors du démarrage du job : " + e.getMessage();
        }
    }
}
