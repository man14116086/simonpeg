/* =========================================================
   Dashboard charts configuration - Chart.js
   ========================================================= */
document.addEventListener('DOMContentLoaded', () => {
    const golonganCtx = document.getElementById('golonganChart');
    const unitKerjaCtx = document.getElementById('unitKerjaChart');

    if (golonganCtx) {
        new Chart(golonganCtx, {
            type: 'bar',
            data: {
                labels: golonganLabels,
                datasets: [{
                    label: 'Jumlah Pegawai',
                    data: golonganData,
                    borderRadius: 8,
                    backgroundColor: 'rgba(29, 93, 180, 0.85)'
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: { legend: { display: false } },
                scales: { y: { beginAtZero: true, ticks: { precision: 0 } } }
            }
        });
    }

    if (unitKerjaCtx) {
        new Chart(unitKerjaCtx, {
            type: 'pie',
            data: {
                labels: unitKerjaLabels,
                datasets: [{
                    data: unitKerjaData,
                    backgroundColor: [
                        '#1d5db4',
                        '#3f8ef3',
                        '#6ca8f8',
                        '#90bbfa',
                        '#bed8fc'
                    ]
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'bottom',
                        labels: { boxWidth: 12 }
                    }
                }
            }
        });
    }
});
